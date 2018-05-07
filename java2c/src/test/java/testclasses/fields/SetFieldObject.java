package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetFieldObject
{
    private String fieldL;

    public SetFieldObject()
    {
        this.fieldL = "hello";
        this.setField("world");
    }

    public String getField()
    {
        return this.fieldL;
    }

    @Obfuscation
    public void setField(String value){this.fieldL = value;}
}
