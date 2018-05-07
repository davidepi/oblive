package testclasses.casts; //when changing this, remember to change also the variable in eu.fbk.hardening.helpers

import eu.fbk.hardening.annotation.Obfuscation;

public class CastInt2Byte
{
    public CastInt2Byte()
    {

    }

    @Obfuscation
    public byte exec(int a)
    {
        return (byte)(a+a);
    }

}
