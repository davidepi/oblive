package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionXLOADInt
{
    public ThrowNullPointerExceptionXLOADInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        return obj.b[1];
    }
}
