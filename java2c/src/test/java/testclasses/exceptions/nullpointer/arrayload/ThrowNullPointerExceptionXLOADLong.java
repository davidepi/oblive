package testclasses.exceptions.nullpointer.arrayload;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXLOADLong
{
    public ThrowNullPointerExceptionXLOADLong()
    {

    }

    @Obfuscate
    public int exec(SupportClassLong obj)
    {
        return (int)obj.b[1];
    }
}
