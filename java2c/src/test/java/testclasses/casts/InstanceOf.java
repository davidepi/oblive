package testclasses.casts;

import it.se.obfuscator.Obfuscate;

public class InstanceOf
{
    public InstanceOf()
    {

    }

    @Obfuscate
    public static boolean instanceofString(Object a)
    {
        return a instanceof String;
    }
}
