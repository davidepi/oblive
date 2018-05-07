package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class ThrowArrayStoreException
{
    private Object array[];
    public ThrowArrayStoreException()
    {
        this.array = new String[2];
        this.array[0] = "hello";
        this.array[1] = "world";
    }

    @Obfuscation
    public Object exec()
    {
        this.array[1] = 1;
        return this.array[1];
    }
}
