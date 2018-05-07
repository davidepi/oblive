package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeSpecialDouble extends InvokeVirtualDouble
{
    public InvokeSpecialDouble()
    {

    }

    @Obfuscation
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