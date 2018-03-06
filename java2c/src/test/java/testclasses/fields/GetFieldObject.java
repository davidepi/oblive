package testclasses.fields;

import it.se.obfuscator.Obfuscate;

public class GetFieldObject
{
    private String fieldL;

    public GetFieldObject()
    {
        this.fieldL = "hello world";
    }

    @Obfuscate
    public String getField()
    {
        return this.fieldL;
    }
}
