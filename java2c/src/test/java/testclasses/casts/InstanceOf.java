package testclasses.casts;

import eu.fbk.hardening.annotation.Obfuscation;

public class InstanceOf
{
    public InstanceOf()
    {

    }

    @Obfuscation
    public static boolean instanceofString(Object a)
    {
        return a instanceof String;
    }
}
