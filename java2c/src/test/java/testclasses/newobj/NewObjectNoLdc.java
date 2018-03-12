package testclasses.newobj;

import it.se.obfuscator.Obfuscate;

public class NewObjectNoLdc
{
    public NewObjectNoLdc()
    {

    }

    @Obfuscate
    public TestingObjectNoLdc getObject(int a, long b, double c, String d)
    {
        return new TestingObjectNoLdc(a,b,System.out,c,d);
    }
}
