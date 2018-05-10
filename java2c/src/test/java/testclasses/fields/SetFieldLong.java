package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class SetFieldLong
{
    private long fieldJ;

    public SetFieldLong()
    {
        this.fieldJ = 10000000000L;
        this.setField(-50000000000L);
    }

    public long getField()
    {
        return this.fieldJ;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setField(long value)
    {
        this.fieldJ = value;
    }
}
