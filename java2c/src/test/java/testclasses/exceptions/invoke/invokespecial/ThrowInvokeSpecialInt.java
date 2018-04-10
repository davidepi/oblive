package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class ThrowInvokeSpecialInt extends InvokeVirtualInt
{
    public ThrowInvokeSpecialInt()
    {

    }

    @Obfuscate
    @Override
    public int add(int a, int b)
    {
        return super.normalAdd(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public int normalAdd(int a, int b)
    {
        return a - b;
    }
}