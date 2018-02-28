package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;
import testclasses.invoke.invokevirtual.InvokeVirtualDouble;

public class InvokeSpecialDouble extends InvokeVirtualDouble
{
    public InvokeSpecialDouble()
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