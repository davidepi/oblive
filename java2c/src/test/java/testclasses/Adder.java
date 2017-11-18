package testclasses; //when changing this, remember to change also the variable in it.se.obfuscator.helpers

import it.se.obfuscator.Obfuscate;

public class Adder
{
    public Adder()
    {

    }

    @Obfuscate
    public static int add(int a, int b)
    {
        return a + b;
    }

}
