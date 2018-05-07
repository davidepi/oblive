package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class GetFieldObject
{
    private String fieldL;

    public GetFieldObject()
    {
        this.fieldL = "hello world";
    }

    @Obfuscation
    public String getField()
    {
        return this.fieldL;
    }
}
