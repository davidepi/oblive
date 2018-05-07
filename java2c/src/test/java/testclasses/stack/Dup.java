package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;

public class Dup
{
    public Dup()
    {

    }

    @Obfuscation
    public int exec()
    {
        TestingObjectDup obj = new TestingObjectDup();
        ++(obj.a);
        return obj.a;
    }
}
