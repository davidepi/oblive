package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class Pop
{
    private boolean val;

    public Pop()
    {
        this.val = false;
    }

    @Obfuscate
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
