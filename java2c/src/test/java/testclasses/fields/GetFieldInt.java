package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldInt
{
    private int fieldI;

    public GetFieldInt()
    {
        this.fieldI = 1000000;
    }

    @Obfuscate
    public int getField(int a)
    {
        return this.fieldI;
    }
}
