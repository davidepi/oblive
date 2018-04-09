package testclasses.exceptions.nullpointer.arraylength;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionArrayLengthFloat
{
    public ThrowNullPointerExceptionArrayLengthFloat()
    {

    }

    @Obfuscate
    public int exec(SupportClassFloat obj)
    {
        return obj.b.length;
    }
}
