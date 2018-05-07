package testclasses.exceptions.nullpointer.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXLOADFloat
{
    public ThrowNullPointerExceptionXLOADFloat()
    {

    }

    @Obfuscation
    public int exec(SupportClassFloat obj)
    {
        return (int)obj.b[1];
    }
}
