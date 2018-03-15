package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class DupX1
{
    private TestingObjectDup obj;
    public DupX1()
    {
        this.obj = new TestingObjectDup();
    }

    @Obfuscate
    public int exec()
    {
        obj.setValue(obj.a=2);
        return obj.a;
    }
}
