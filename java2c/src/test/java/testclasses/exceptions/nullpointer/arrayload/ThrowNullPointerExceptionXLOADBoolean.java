package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionXLOADBoolean
{
    public ThrowNullPointerExceptionXLOADBoolean()
    {

    }

    @Obfuscate
    public int exec(SupportClassBoolean obj)
    {
        return obj.b[1]?1:0;
    }
}
