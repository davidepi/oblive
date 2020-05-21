package testclasses.conditionals;

import it.oblive.annotations.NativeObfuscation;

public class Ifnonnull {
    public Ifnonnull() {

    }

    @NativeObfuscation
    public boolean exec(Object value) {
        return value == null;
    }

}
