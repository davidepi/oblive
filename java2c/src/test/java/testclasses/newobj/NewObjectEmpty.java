package testclasses.newobj;

import it.se.obfuscator.Obfuscate;

public class NewObjectEmpty
{
    public NewObjectEmpty()
    {

    }

    @Obfuscate
    public String getObject()
    {
        return new String();
    }
}
