package testclasses;

import it.oblive.annotations.NativeObfuscation;

public class CollidingString {
    public CollidingString() {

    }

    //test strings with the same content, that in Java are mapped onto LDC commands (used to ensure that I do not create
    // variables with same name)
    @NativeObfuscation
    public static String exec() {
        String a = "a";
        String b = "a";
        String c = "a";
        String d = "longer";
        String e = "longest";
        String f = "longer";
        return a + b + c + d + e + f;
    }
}
