package testclasses.newobj;

import eu.fbk.hardening.annotation.Obfuscation;

public class NewObjectLdc
{
    public NewObjectLdc()
    {

    }

    @Obfuscation
    public TestingObjectLdc getObject()
    {
        return new TestingObjectLdc(1000000,10000000000L,System.out,3.5,3.5f,"hello", (short)3000, true, 'A', (byte)250);
    }
}
