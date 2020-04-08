package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class IDiv {
    public IDiv() {

    }

    @NativeObfuscation
    public int exec(int a, int b) {
        return a / b;
    }

}
