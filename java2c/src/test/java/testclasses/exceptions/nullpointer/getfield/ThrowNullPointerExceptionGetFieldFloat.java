package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionGetFieldFloat
{
    public ThrowNullPointerExceptionGetFieldFloat()
    {

    }

    @Obfuscate
    public float exec(SupportClassFloat obj)
    {
        return obj.a;
    }
}
