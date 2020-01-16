package testclasses.exceptions;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class NestedCatchClassCastException {
    public NestedCatchClassCastException() {

    }

    @NativeObfuscation
    public static String castString(Object a) {
        String retval = "";
        try {
            try {
                retval = (String) a;
                retval += "a";
            } catch (ClassCastException e) {
                retval = "wrongest input type";
            }
            retval = (String) a;
        } catch (ClassCastException e) {
            retval += "wrong input type";
        } catch (Throwable e) {
            retval = "ouch";
        }
        return retval;
    }
}
