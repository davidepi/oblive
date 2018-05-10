package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

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

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(int value)
    {
        this.fieldI = value;
    }
}
