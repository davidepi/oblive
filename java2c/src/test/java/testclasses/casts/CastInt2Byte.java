package testclasses.casts; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class CastInt2Byte
{
    public CastInt2Byte()
    {

    }

    @Obfuscate
    public byte exec(int a)
    {
        return (byte)(a+a);
    }

}
