package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXLOADLong
{
    public ThrowNullPointerExceptionXLOADLong()
    {

    }

    @Obfuscation
    public int exec(SupportClassLong obj)
    {
        return (int)obj.b[1];
    }
}
