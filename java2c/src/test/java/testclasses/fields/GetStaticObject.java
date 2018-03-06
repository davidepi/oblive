package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetStaticObject
{
    private static String fieldL;

    public GetStaticObject()
    {
        GetStaticObject.fieldL = "hello world";
    }

    @Obfuscate
    public String getStatic()
    {
        return GetStaticObject.fieldL;
    }
}
