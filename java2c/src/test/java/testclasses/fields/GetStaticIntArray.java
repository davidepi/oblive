package testclasses.fields;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class GetStaticIntArray
{
    static int[] array;

    public GetStaticIntArray()
    {
        array = new int[10];
    }

    @Obfuscate
    public int[] getArray()
    {
        return this.array;
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
