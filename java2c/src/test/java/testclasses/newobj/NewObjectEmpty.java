package testclasses.newobj;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class NewObjectEmpty
{
    public NewObjectEmpty()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String getObject()
    {
        return new String();
    }
}
