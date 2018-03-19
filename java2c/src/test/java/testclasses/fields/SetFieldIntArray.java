package testclasses.fields;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class SetFieldIntArray
{
    private int[] array;

    public SetFieldIntArray()
    {

    }

    @Obfuscate
    public void setArray(int[] array){this.array = array;};

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.array;
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
