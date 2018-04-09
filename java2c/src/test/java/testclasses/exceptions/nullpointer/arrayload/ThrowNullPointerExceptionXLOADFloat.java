package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXLOADFloat
{
    public ThrowNullPointerExceptionXLOADFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
    {
        return (int)obj.b[1];
    }
}
