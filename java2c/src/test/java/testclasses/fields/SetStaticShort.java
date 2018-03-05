package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticShort
{
    private static int fieldS;

    public SetStaticShort()
    {
        SetStaticShort.fieldS = 3000;
        this.setStatic(-3000);
    }

    public int getStatic()
    {
        return SetStaticShort.fieldS;
    }

    @Obfuscate
    public void setStatic(int value)
    {
        SetStaticShort.fieldS = value;
    }
}
