package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

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

    @Obfuscation
    public void setStatic(short value)
    {
        SetStaticShort.fieldS = value;
    }
}
