package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;
import java.util.Arrays;

public class NewArrayInt
{
    public NewArrayInt()
    {

    }

    @Obfuscate
    public int[] getArray()
    {
        return new int[10];
    }

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
