package testclasses.invoke.invokevirtual;

import it.oblive.annotations.NativeObfuscation;

//saving the result of the JNI fun CallCharMethod inside a char performs strange casts and returns wrong errors if the
//char is later retrieved as int
public class InvokeVirtualCastChar {
    public InvokeVirtualCastChar() {

    }

    @NativeObfuscation
    public boolean add(char a, char b) {
        return normalAdd(a, b) == (char) (a + b);
    }

    public char normalAdd(char a, char b) {
        return (char) (a + b);
    }
}