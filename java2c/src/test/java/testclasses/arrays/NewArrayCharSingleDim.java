package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayCharSingleDim
{
    public NewArrayCharSingleDim()
    {

    }

    @Obfuscate
    public char[] getArray()
    {
        return new char[10];
    }

    public ArrayList<Character> test()
    {
        ArrayList<Character> res = new ArrayList<Character>(10);
        char[] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
