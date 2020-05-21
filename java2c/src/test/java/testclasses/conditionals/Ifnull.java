package testclasses.conditionals;

import it.oblive.annotations.NativeObfuscation;

public class Ifnull {
    public Ifnull() {

    }

    @NativeObfuscation
    public boolean exec(Object value) {
        return value != null;
    }

}
