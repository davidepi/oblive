package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class Dup
{
    public Dup()
    {

    }

    @Obfuscate
    public int exec()
    {
        TestingObjectDup obj = new TestingObjectDup();
        ++(obj.a);
        return obj.a;
    }
}
