package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;
import testclasses.invoke.invokevirtual.InvokeVirtualDouble;
import testclasses.invoke.invokevirtual.InvokeVirtualFloat;

public class InvokeSpecialFloat extends InvokeVirtualFloat
{
    public InvokeSpecialFloat()
    {

    }

    @Obfuscate
    @Override
    public float add(float a, float b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public float normalAdd(float a, float b)
    {
        return (a - b);
    }
}