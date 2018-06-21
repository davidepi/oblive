package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LengthArrayByte
{
    private byte[][] array;

    public LengthArrayByte()
    {
        this.array = new byte[3][2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int getLen()
    {
        return this.array.length;
    }

}
