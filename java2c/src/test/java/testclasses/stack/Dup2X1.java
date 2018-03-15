package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class Dup2X1
{
    private TestingObjectDup obj;
    public Dup2X1()
    {
        this.obj = new TestingObjectDup();
    }

    @Obfuscate
    public double exec()
    {
        obj.setValue(obj.b=2);
        return obj.b;
    }
}
