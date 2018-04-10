package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayObject
{
    private String[] array;

    public StoreArrayObject()
    {
        this.array = new String[]{"hello","hello","hello","hello","hello","hello","hello","hello","hello","hello"};
    }

    @Obfuscate
    public void setVal(int i, String val)
    {
        this.array[i] = val;
    }

    public ArrayList<String> test()
    {
        ArrayList<String> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i,"unicode 世界");
        //assert that also the rest of the array is unchanged
        for(int j=0;j<this.array.length;j++)
            retval.add(array[j]);
        return retval;
    }

}