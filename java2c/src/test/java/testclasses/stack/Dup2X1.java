package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;

public class Dup2X1
{
    private TestingObjectDup obj;
    public Dup2X1()
    {
        this.obj = new TestingObjectDup();
    }

    @Obfuscation
    public double exec()
    {
        obj.setValue(obj.b=2);
        return obj.b;
    }
}
