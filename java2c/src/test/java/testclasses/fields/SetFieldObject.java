package testclasses.fields;

import it.se.obfuscator.Obfuscate;

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

    @Obfuscate
    public void setField(String value){this.fieldL = value;}
}
