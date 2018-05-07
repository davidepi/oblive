package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetStaticObject
{
    private static String fieldL;

    public GetStaticObject()
    {
        GetStaticObject.fieldL = "hello world";
    }

    @Obfuscation
    public String getStatic()
    {
        return GetStaticObject.fieldL;
    }
}
