package testclasses.exceptions.nullpointer.getfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionGetFieldBoolean
{
    public ThrowNullPointerExceptionGetFieldBoolean()
    {

    }

    @Obfuscate
    public boolean exec(SupportClassBoolean obj)
    {
        return obj.a;
    }
}
