package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class IInc {
    public IInc() {

    }

    @NativeObfuscation
    public int exec(int a) {
        a++;
        a--;
        a += 10;
        a -= 20;
        return a;
    }

}
