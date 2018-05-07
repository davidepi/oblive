package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldInt
{
    private int fieldI;

    public GetFieldInt()
    {
        this.fieldI = 1000000;
    }

    @Obfuscation
    public int getField()
    {
        return this.fieldI;
    }
}
