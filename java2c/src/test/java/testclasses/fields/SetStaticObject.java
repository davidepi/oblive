package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class SetStaticObject
{
    private static String fieldL;

    public SetStaticObject()
    {
        SetStaticObject.fieldL = "hello";
        this.setStatic("world");
    }

    public String getStatic()
    {
        return SetStaticObject.fieldL;
    }

    @Obfuscate
    public void setStatic(String value)
    {
        SetStaticObject.fieldL = value;
    }
}
