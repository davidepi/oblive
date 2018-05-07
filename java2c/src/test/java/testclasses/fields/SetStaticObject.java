package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

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

    @Obfuscation
    public void setStatic(String value)
    {
        SetStaticObject.fieldL = value;
    }
}
