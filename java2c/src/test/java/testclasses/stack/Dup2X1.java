package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Dup2X1
{
    private TestingObjectDup obj;

    public Dup2X1()
    {
        this.obj = new TestingObjectDup();
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double exec()
    {
        obj.setValue(obj.b = 2);
        return obj.b;
    }
}
