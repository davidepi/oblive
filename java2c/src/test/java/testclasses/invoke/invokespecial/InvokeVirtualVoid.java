package testclasses.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class InvokeVirtualVoid
{
    public InvokeVirtualVoid()
    {

    }

    @Obfuscation
    public void add(int a, int b)
    {
        print(a,b);
    }

    public void print(int a, int b)
    {
        System.out.println(a+b);
    }
}