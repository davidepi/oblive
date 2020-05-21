package testclasses.arithmetic; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import it.oblive.annotations.NativeObfuscation;

public class LShl {
    public LShl() {

    }

    @NativeObfuscation
    //param 2 is always int. It is casted by the compiler otherwise
    public long exec(long a, int b) {
        return a << b;
    }

}
