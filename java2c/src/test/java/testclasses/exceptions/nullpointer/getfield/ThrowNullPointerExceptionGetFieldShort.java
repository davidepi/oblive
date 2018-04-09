package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionGetFieldShort
{
    public ThrowNullPointerExceptionGetFieldShort()
    {

    }

    @Obfuscate
    public short exec(SupportClassShort obj)
    {
        return obj.a;
    }
}
