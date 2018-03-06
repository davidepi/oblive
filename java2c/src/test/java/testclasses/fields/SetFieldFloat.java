package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetFieldFloat
{
    private float fieldF;

    public SetFieldFloat()
    {
        this.fieldF = 3.5f;
        this.setField(-0.5f);
    }

    public float getField()
    {
        return this.fieldF;
    }

    @Obfuscate
    public void setField(float value){this.fieldF = value;}
}
