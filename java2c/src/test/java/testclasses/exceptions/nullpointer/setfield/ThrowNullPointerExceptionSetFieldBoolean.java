package testclasses.exceptions.nullpointer.setfield;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.nullpointer.SupportClassBoolean;

public class ThrowNullPointerExceptionSetFieldBoolean
{
    public ThrowNullPointerExceptionSetFieldBoolean()
    {

    }

    @Obfuscate
    public boolean exec(SupportClassBoolean obj)
    {
        obj.a = false;
        return true;
    }
}
