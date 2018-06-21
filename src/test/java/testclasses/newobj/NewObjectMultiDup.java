package testclasses.newobj;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class NewObjectMultiDup
{
    public NewObjectMultiDup()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public TestingObjectMultiDup getObject()
    {
        int a = 1;
        TestingObjectMultiDup b = new TestingObjectMultiDup(1, 1, 1, 1);
        return new TestingObjectMultiDup(a, ++b.a, a, a);
    }
}
