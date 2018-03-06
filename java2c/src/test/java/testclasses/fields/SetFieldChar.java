package testclasses.fields;

import it.se.obfuscator.Obfuscate;

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

    @Obfuscate
    public void setField(char value){this.fieldC = value;}
}
