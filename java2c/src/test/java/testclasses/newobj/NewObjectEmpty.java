package testclasses.newobj;

import eu.fbk.hardening.annotation.Obfuscation;

public class NewObjectEmpty
{
    public NewObjectEmpty()
    {

    }

    @Obfuscation
    public String getObject()
    {
        return new String();
    }
}
