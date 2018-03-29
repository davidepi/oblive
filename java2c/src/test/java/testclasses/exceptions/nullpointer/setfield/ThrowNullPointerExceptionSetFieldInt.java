package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionSetFieldInt
{
    public ThrowNullPointerExceptionSetFieldInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        obj.a = 0;
        return 0;
    }
}
