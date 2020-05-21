package testclasses.conditionals;

import it.oblive.annotations.NativeObfuscation;

public class Ificmple {
    public Ificmple() {

    }

    @NativeObfuscation
    public boolean exec(int value) {
        return value > 1000000000;
    }

}
