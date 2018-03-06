package testclasses.newobj;

import it.se.obfuscator.Obfuscate;

public class NewObjectNoLdc
{
    public NewObjectNoLdc()
    {

    }

    @Obfuscate
    public ObjNoLdc getObject(int a, long b, double c, String d)
    {
        return new ObjNoLdc(a,b,System.out,c,d);
    }
}
