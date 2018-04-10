package testclasses;

import it.se.obfuscator.Obfuscate;

public class MultiMethods
{
    public MultiMethods()
    {

    }

    @Obfuscate
    public int add(int a, int b)
    {
        return a + b;
    }

    @Obfuscate
    public int sub(int a, int b)
    {
        return a - b;
    }

    @Obfuscate
    public int mul(int a, int b)
    {
        return a * b;
    }

    @Obfuscate
    public int div(int a, int b)
    {
        return a / b;
    }
}
