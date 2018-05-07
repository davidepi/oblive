package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

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

    @Obfuscation
    public void setField(boolean value){this.fieldZ = value;}
}
