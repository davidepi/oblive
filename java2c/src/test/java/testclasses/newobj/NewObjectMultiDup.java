package testclasses.newobj;

import it.se.obfuscator.Obfuscate;
import testclasses.stack.TestingObjectDup;

public class NewObjectMultiDup
{
    public NewObjectMultiDup()
    {

    }

    @Obfuscate
    public TestingObjectMultiDup getObject()
    {
        int a = 1;
        TestingObjectMultiDup b = new TestingObjectMultiDup(1,1,1,1);
        return new TestingObjectMultiDup(a,++b.a,a,a);
    }
}
