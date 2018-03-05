package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticByte
{
    private static byte fieldB;

    public SetStaticByte()
    {
        SetStaticByte.fieldB = 100;
        this.setStatic((byte)-100);
    }

    public byte getStatic()
    {
        return SetStaticByte.fieldB;
    }

    @Obfuscate
    public void setStatic(byte value)
    {
        SetStaticByte.fieldB = value;
    }
}
