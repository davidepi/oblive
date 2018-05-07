package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassDouble;

public class ThrowNullPointerExceptionXSTOREDouble
{
    public ThrowNullPointerExceptionXSTOREDouble()
    {

    }

    @Obfuscation
    public int exec(SupportClassDouble obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
