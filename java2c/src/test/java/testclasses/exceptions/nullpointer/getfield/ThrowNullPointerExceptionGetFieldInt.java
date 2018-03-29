package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class ThrowNullPointerExceptionGetFieldInt
{
    public ThrowNullPointerExceptionGetFieldInt()
    {

    }

    @Obfuscate
    public int exec(SupportClassInt obj)
    {
        return obj.a;
    }
}
