package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchClassCastException {
    public CatchClassCastException() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String castString(Object a) {
        String retval = "";
        try {
            retval = (String) a;
            retval += "a";
        } catch (ClassCastException e) {
            retval += "wrong ";
        }

        try {
            retval = (String) a;
            retval += "b";
        } catch (RuntimeException e) {
            retval += "type ";
        }

        try {
            retval = (String) a;
            retval += "c";
        } catch (Exception e) {
            retval += "exception ";
        }

        try {
            retval = (String) a;
            retval += "d";
        } catch (Throwable e) {
            retval += "! ";
        }

        return retval;
    }
}