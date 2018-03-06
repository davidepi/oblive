package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldBoolean
{
    private boolean fieldZ;

    public SetFieldBoolean()
    {
        this.fieldZ = false;
        this.setField(true);
    }

    public boolean getField()
    {
        return this.fieldZ;
    }

    @Obfuscate
    public void setField(boolean value){this.fieldZ = value;}
}
