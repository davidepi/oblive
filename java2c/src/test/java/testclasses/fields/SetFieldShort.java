package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldShort
{
    private int fieldS;

    public SetFieldShort()
    {
        this.fieldS = 3000;
        this.setField(-3000);
    }

    public int getField()
    {
        return this.fieldS;
    }

    @Obfuscate
    public void setField(int value){this.fieldS = value;}
}
