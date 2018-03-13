package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class DupX2
{
    private TestingObjectDup obj;
    public DupX2()
    {
        this.obj = new TestingObjectDup();
    }

    @Obfuscate
    public int exec()
    {
        int a = 2;
        int b = 3;
        int c = 3;
        c=++c+(b=3);
        return obj.a;
    }
}
