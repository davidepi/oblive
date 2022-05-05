# Oblive

![ci badge](https://github.com/davidepi/oblive/actions/workflows/ci.yml/badge.svg)

Oblive is a hardening tool that enables C obfuscations and antidebugging in languages running on the Java Virtual Machine (e.g. Java, Kotlin, ...).
Protections are performed automatically, with the user having only to signal, with an annotation, which part of the code to protect.

**DISCLAIMER**: This project is purely academic and does not meet the engineering standards required for a safe production usage.
Please do **NOT** use this code in production.

## Usage

### Build the transformator
First, ensure that a JDK and `gcc` are installed in the system.
To build the obfuscation and antidebugging tools, clone this repository, and build its contents with the following command:

```bash
./gradlew build && ./gradlew jar
```
This will run a long (several minutes) test suite to ensure the transformator correctness and will produce the transformator `.jar` file inside the sub-folder `oblive/build/libs`. Note that this is not the build folder in the root of the project.

If the tests fail to run and `gcc` is installed in the system and in the `PATH` variable, the `JAVA_HOME` variable may be pointing to a wrong folder. Unsetting this variable should fix the issue.

Alternatively, the built jar can be found in the release section.

### Annotate the project to protect

The decision on which method to protect is left to the user, and the project to protect must be annotated accordingly.
In order to do so the following steps are necessary.

- Add the `it.oblive.annotations` jar built in the previous step as a local dependency in the Gradle or Maven (at the time of writing GitHub does not allow unauthorized access to Maven packages hence the reason of the local dependency). The jar is `annotations/build/libs/annotations-1.0.0.jar`, from the root of the current repository.
- Import the annotation(s) with the `import it.oblive.annotations.*;` statement and annotate the method(s) to protect, then build the application jar.

  **NOTE:** the `@NativeObfuscation` annotation is required in order to apply antidebugging.

### Apply the protection(s)

The following command will run the transformator

```bash
java -jar oblive-1.0.0.jar <annotated_jar>.jar <output>.jar
```

where `<annotated_file>.jar` is the jar containing the annotated methods that will be protected, and `<output>.jar` is the results of the operation. This will likely generate additional files such as a `.so` library (the JNI part) and, if `@AntidebugSelf` was requested, an extcutable (the OVM).

 This implementation currently works on the `x86_64` architecture and *nix kernels only.

### Run the protected jar

In order to run the protected application jar, there are two considerations to keep in mind:

- The `libnative.so` library must be in the `java.library.path`. This is a limitation of the java language itself. In order to do so it is necessary to run the jar with the argument `-Djava.library.path=<path to libnative.so folder>`.
- If `@AntidebugSelf` was requested, the additional executable must be in PATH in order to be run.

After applying the protection, both the `.so` file and the additional executable will be in the same folder. To run the jar it is thus sufficient to move into that folder and run the following command:
```bash
java -Djava.library.path=. -jar <output>.jar
```
with `<output>.jar` being the same name specified in the previous subsection.

Note that `@AntidebugSelf` requires libcrypto to be installed in the system.

## Protections

Brief description of all the protections that can be applied.

The package `it.oblive.annotations` contains the Java Annotations that should be used to specify methods to be protected.
The annotations are the following:
- `@NativeObfuscation`: methods with this annotation are removed from their respective `.class` file and replaced with a semantically equivalent C implementation.
- `@AntidebugTime`: methods with this annotation implement time-check antidebugging and backend damaging. This is a trivial type of antidebugging with very low resilience.
- `@AntidebugSelf`: methods with this annotation implement self-debug antidebugging and backend damaging. The self debugging implemented by this annotation is currently state-of-the-art antidebugging, albeit with a heavy execution time cost.


### Native translation (Java2C)
The `@NativeObfuscation` annotation uses the *Java2C* tool, contained in this repository, to translate a Java bytecode method into a C method.
The steps performed are the following:
- The body of a method with the `@NativeObfuscation` keyword is removed from the original Java bytecode
- The method signature is changed to `native`, indicating that the method implementation can be found in a native library
- The removed body is parsed instruction by instruction, each JVM opcode is replaced [by a C implementation](java2c/src/main/resources) inside a JNI method. The code responsible of generating the JNI layer is [the following](java2c/src/main/java/it/oblive/CSourceGenerator.java).
- The static init method of the original class containing the annotated method is modified, so the class can load the compiled C implementation at runtime

More information can be found in the paper
> Obfuscating Java Programs by Translating Selected Portions of Bytecode to Native Libraries
>
> D. Pizzolotto, M. Ceccato
>

### Self-debug Antidebugging
The self-debug antidebugging protection is very complex, and only the major key points are
listed in this README.

The protection works in the following way:
- The protected method is translated to C using *Java2C*.
- An additional VM called OVM is spawned and debugs the JNI. The JNI, in turn, debugs the OVM.
- To prevent an attacker from killing the OVM, the C implementation of some JVM opcodes can be found only in the OVM. When the JNI translation of the method requires one of these opcodes, it needs to ask the OVM to perform the computation.
- JNI and OVM communication is encrypted using OTP. The OTP is generated by a PRNG seeded equally by both JNI and OVM. This is done solely to make the `ptrace` mandatory. In fact, the seed of the PRNG is generated half on the JNI and half on the OVM, then exchanged using the `ptrace` call. For this reason, an attacker can not replace the `ptrace` with `NOOP` (and thus enable debugging) otherwise JNI and OVM will miscommunicate.
- To prevent an attacker from performing Man-in-the-Middle attacks between JNI and OVM, the two processes are authenticated using an AES key generated at compile time.

The code for this protection is contained inside the *Java2C* component of this repository.
In particular, the code for the OVM is contained in the [antidebug.c file](java2c/src/main/resources/antidebug.c), and the (additional) code for the JNI layer in the [antidebug.h file](java2c/src/main/resources/antidebug.h).

More information can be found in the paper
> Mitigating Debugger-based Attacks to Java Applications with Self-Debugging
>
> D. Pizzolotto, S. Berlato, M. Ceccato
>

### Backend damaging

This protection is applied when any antidebugging is requested. The purpose of this protection is to prevent an attacker
from circumventing the antidebugging protection with a blackbox analysis and input/output manipulation of the protected method.
In order to do so, the backend damaging messes up with the Java Debug Wire Protocol (JDWP), used to debug JVM programs, and destroys the debugging capabilities of the Java Platform Debugger Architecture (JPDA).

The code for this protection is contained in the [antidebug.h file](java2c/src/main/resources/antidebug.h)

## Repo Structure

The project is composed by the following elements:
- [annotations](annotations): contains the annotations that should be used by the user to signal which methods to protect.
- [java2c](java2c): contains the *Java2C* program, resposible of applying the `@Native` and `@AntidebugSelf` protections to `.class` files.
- [oblive](oblive): contains the *Oblive* program, responsible of unpacking an input `.jar`, calling *Java2C* for all the `.class` files, packing the output `.class` into a `.jar` and compiling the generated files.

## Authors

- [Davide Pizzolotto](https://github.com/davidepi) - Java2C and Self-debug protection
- [Stefano Berlato](https://github.com/StefanoBerlato) - JDWP manipulation and backend damaging
- [Luca Gasparetto](https://github.com/LucaGaspa) - Moral supporter for Java2C
- Mariano Ceccato - Supervisor
