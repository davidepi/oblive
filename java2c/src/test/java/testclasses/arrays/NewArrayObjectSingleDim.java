package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayObjectSingleDim
{
    public NewArrayObjectSingleDim()
    {

    }

    @Obfuscate
    public String[] getArray()
    {
        return new String[2];
    }

    public ArrayList<String> test()
    {
        ArrayList<String> res = new ArrayList<String>(10);
        String[] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
