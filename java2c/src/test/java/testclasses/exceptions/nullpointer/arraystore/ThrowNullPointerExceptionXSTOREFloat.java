package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class ThrowNullPointerExceptionXSTOREFloat
{
    public ThrowNullPointerExceptionXSTOREFloat()
    {

    }

    @Obfuscation
    public int exec(SupportClassFloat obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
