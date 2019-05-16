package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//saving the result of the JNI fun CallCharMethod inside a char performs strange casts and returns wrong errors if the
//char is later retrieved as int
public class InvokeVirtualCastChar {
    public InvokeVirtualCastChar() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}