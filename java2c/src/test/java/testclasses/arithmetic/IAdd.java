package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotations.NativeObfuscation;

public class IAdd {
    public IAdd() {

    }

    @NativeObfuscation
    public int exec(int a, int b) {
        return a + b;
    }

}