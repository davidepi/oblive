package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionXLOADShort
{
    public ThrowNullPointerExceptionXLOADShort()
    {

    }

    @Obfuscate
    public int exec(SupportClassShort obj)
    {
        return obj.b[1];
    }
}
