package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;

public class MultiMethods
{
    public MultiMethods()
    {

    }

    @Obfuscation
    public int add(int a, int b)
    {
        return a + b;
    }

    @Obfuscation
    public int sub(int a, int b)
    {
        return a - b;
    }

    @Obfuscation
    public int mul(int a, int b)
    {
        return a * b;
    }

    @Obfuscation
    public int div(int a, int b)
    {
        return a / b;
    }
}
