package testclasses.newobj;

import eu.fbk.hardening.annotations.NativeObfuscation;

public class NewObjectEmpty {
    public NewObjectEmpty() {

    }

    @NativeObfuscation
    public String getObject() {
        return "";
    }
}
