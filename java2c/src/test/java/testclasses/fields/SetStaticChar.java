package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetStaticChar
{
    private static char fieldC;

    public SetStaticChar()
    {
        SetStaticChar.fieldC = 'z';
        this.setStatic('a');
    }

    public char getStatic()
    {
        return SetStaticChar.fieldC;
    }

    @Obfuscation
    public void setStatic(char value)
    {
        SetStaticChar.fieldC = value;
    }
}
