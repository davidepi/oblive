package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialDouble extends InvokeVirtualDouble
{
    public ThrowInvokeSpecialDouble()
    {

    }

    @Obfuscate
    @Override
    public double add(double a, double b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public double normalAdd(double a, double b)
    {
        return (a - b);
    }
}
