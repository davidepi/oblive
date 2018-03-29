package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionSetFieldFloat
{
    public ThrowNullPointerExceptionSetFieldFloat()
    {

    }

    @Obfuscate
    public float exec(SupportClassFloat obj)
    {
        obj.a = 0;
        return 0;
    }
}
