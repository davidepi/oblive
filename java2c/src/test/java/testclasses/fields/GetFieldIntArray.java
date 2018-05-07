package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;

import java.util.ArrayList;

public class GetFieldIntArray
{
    int[] array;

    public GetFieldIntArray()
    {
        array = new int[10];
    }

    @Obfuscation
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
