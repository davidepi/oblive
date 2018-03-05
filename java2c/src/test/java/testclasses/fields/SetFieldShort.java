package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldShort
{
    private short fieldS;

    public SetFieldShort()
    {
        this.fieldS = 3000;
        this.setField((short)-3000);
    }

    public short getField()
    {
        return this.fieldS;
    }

    @Obfuscate
    public void setField(short value){this.fieldS = value;}
}
