package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldInt
{
    private int fieldI;

    public SetFieldInt()
    {
        this.fieldI = 1000000;
        this.setField(-1000000);
    }

    public int getField()
    {
        return this.fieldI;
    }

    @Obfuscate
    public void setField(int value){this.fieldI = value;}
}
