package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassShort;

public class ThrowNullPointerExceptionSetFieldShort
{
    public ThrowNullPointerExceptionSetFieldShort()
    {

    }

    @Obfuscate
    public short exec(SupportClassShort obj)
    {
        obj.a = 0;
        return 0;
    }
}
