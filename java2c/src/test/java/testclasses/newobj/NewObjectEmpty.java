package testclasses.newobj;

import it.oblive.annotations.NativeObfuscation;

public class NewObjectEmpty {
    public NewObjectEmpty() {

    }

    @NativeObfuscation
    public String getObject() {
        return "";
    }
}
