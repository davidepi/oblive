package testclasses.stack;

import it.se.obfuscator.Obfuscate;

public class Pop2
{
    private boolean val;

    public Pop2()
    {
        this.val = false;
    }

    @Obfuscate
    public boolean exec()
    {
        this.setVal();
        return this.val;
    }

    private double setVal()
    {
        this.val = true;
        return 1;
    }
}
