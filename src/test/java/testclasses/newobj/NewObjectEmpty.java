package testclasses.newobj;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class NewObjectEmpty {
    public NewObjectEmpty() {

    }

    @NativeObfuscation
    public String getObject() {
        return "";
    }
}
