package testclasses.fields;

import it.se.obfuscator.Obfuscate;

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

    @Obfuscate
    public void setStatic(char value)
    {
        SetStaticChar.fieldC = value;
    }
}
