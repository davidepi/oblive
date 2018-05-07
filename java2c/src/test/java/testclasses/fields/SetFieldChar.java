package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

public class SetFieldChar
{
    private char fieldC;

    public SetFieldChar()
    {
        this.fieldC = 'z';
        this.setField('a');
    }

    public char getField()
    {
        return this.fieldC;
    }

    @Obfuscation
    public void setField(char value){this.fieldC = value;}
}
