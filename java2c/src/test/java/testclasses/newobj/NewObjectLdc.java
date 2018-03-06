package testclasses.newobj;

import it.se.obfuscator.Obfuscate;

public class NewObjectLdc
{
    public NewObjectLdc()
    {

    }

    @Obfuscate
    public TestingObjectLdc getObject()
    {
        return new TestingObjectLdc(1000000,10000000000L,System.out,3.5,3.5f,"hello", (short)3000, true, 'A', (byte)250);
    }
}
