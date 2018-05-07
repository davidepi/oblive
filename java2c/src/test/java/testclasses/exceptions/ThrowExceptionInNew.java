package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowExceptionInNew
{
    public ThrowExceptionInNew()
    {

    }

    @Obfuscation
    public int exec()
    {
        new ClassExceptionInInit();
        return 0;
    }
}
