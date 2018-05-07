package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetStaticInt
{
    private static int fieldI;

    public SetStaticInt()
    {
        SetStaticInt.fieldI = 1000000;
        this.setStatic(-1000000);
    }

    public int getStatic()
    {
        return SetStaticInt.fieldI;
    }

    @Obfuscation
    public void setStatic(int value)
    {
        SetStaticInt.fieldI = value;
    }
}
