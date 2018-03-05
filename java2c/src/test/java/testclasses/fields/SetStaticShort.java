package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticShort
{
    private static short fieldS;

    public SetStaticShort()
    {
        SetStaticShort.fieldS = 3000;
        this.setStatic((short)-3000);
    }

    public short getStatic()
    {
        return SetStaticShort.fieldS;
    }

    @Obfuscate
    public void setStatic(short value)
    {
        SetStaticShort.fieldS = value;
    }
}
