package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticLong
{
    private static long fieldJ;

    public SetStaticLong()
    {
        SetStaticLong.fieldJ = 10000000000L;
        this.setStatic(-50000000000L);
    }

    public long getStatic()
    {
        return SetStaticLong.fieldJ;
    }

    @Obfuscate
    public void setStatic(long value)
    {
        SetStaticLong.fieldJ = value;
    }
}
