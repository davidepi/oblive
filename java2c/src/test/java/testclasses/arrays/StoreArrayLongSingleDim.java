package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayLongSingleDim
{
    private long[] array;

    public StoreArrayLongSingleDim()
    {
        this.array = new long[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    @Obfuscate
    public void setVal(int i, long val)
    {
        this.array[i] = val;
    }

    public ArrayList<Long> test()
    {
        ArrayList<Long> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i,10000000000L);
        //assert that also the rest of the array is unchanged
        for(int j=0;j<this.array.length;j++)
            retval.add(array[j]);
        return retval;
    }

}
