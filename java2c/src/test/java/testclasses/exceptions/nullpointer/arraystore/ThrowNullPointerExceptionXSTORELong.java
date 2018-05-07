package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class ThrowNullPointerExceptionXSTORELong
{
    public ThrowNullPointerExceptionXSTORELong()
    {

    }

    @Obfuscation
    public int exec(SupportClassLong obj)
    {
        obj.b[1] = 1;
        return (int)obj.b[1];
    }
}
