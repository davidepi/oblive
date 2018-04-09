package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowExceptionInNew
{
    public ThrowExceptionInNew()
    {

    }

    @Obfuscate
    public int exec()
    {
        new ClassExceptionInInit();
        return 0;
    }
}
