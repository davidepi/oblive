package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class ThrowArrayStoreException
{
    private Object array[];
    public ThrowArrayStoreException()
    {
        this.array = new String[2];
        this.array[0] = "hello";
        this.array[1] = "world";
    }

    @Obfuscate
    public Object exec()
    {
        this.array[1] = 1;
        return this.array[1];
    }
}
