package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

import static org.junit.Assert.fail;

public class InvokeSpecialVoid extends InvokeVirtualVoid
{
    public InvokeSpecialVoid()
    {

    }

    @Obfuscation
    @Override
    public void add(int a, int b)
    {
        super.print(a,b);
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public void print(int a, int b)
    {
        fail("This should not be called. InvokeSpecial has been implemented wrongly");
    }
}