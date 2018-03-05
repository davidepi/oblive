package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldByte
{
    private byte fieldB;

    public SetFieldByte()
    {
        this.fieldB = 100;
        this.setField((byte)-100);
    }

    public byte getField()
    {
        return this.fieldB;
    }

    @Obfuscate
    public void setField(byte value){this.fieldB = value;}
}
