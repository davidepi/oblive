package testclasses.stack;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class Pop
{
    private boolean val;

    public Pop()
    {
        this.val = false;
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean exec()
    {
        this.setVal();
        return this.val;
    }

    private float setVal()
    {
        this.val = true;
        return 1.f;
    }
}
