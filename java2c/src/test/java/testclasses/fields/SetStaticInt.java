package testclasses.fields;

import it.se.obfuscator.Obfuscate;

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

    @Obfuscate
    public void setStatic(int value)
    {
        SetStaticInt.fieldI = value;
    }
}
