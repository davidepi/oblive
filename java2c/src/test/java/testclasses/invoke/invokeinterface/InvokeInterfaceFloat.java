package testclasses.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class InvokeInterfaceFloat
{
    public InvokeInterfaceFloat()
    {

    }

    @Obfuscate
    public float add(AdderInterface interf, float a, float b)
    {
        return interf.add(a,b);
    }
}