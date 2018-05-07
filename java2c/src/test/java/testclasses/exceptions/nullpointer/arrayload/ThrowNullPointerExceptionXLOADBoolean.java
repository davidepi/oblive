package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXLOADBoolean
{
    public ThrowNullPointerExceptionXLOADBoolean()
    {

    }

    @Obfuscation
    public int exec(SupportClassBoolean obj)
    {
        return obj.b[1]?1:0;
    }
}
