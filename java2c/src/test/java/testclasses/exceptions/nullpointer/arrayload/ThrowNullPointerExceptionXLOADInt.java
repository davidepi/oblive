package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXLOADInt
{
    public ThrowNullPointerExceptionXLOADInt()
    {

    }

    @Obfuscation
    public int exec(SupportClassInt obj)
    {
        return obj.b[1];
    }
}
