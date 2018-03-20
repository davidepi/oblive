package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayLong
{
    private long[][] array;

    public StoreArrayLong()
    {
        this.array = new long[2][10];
        this.array[0] = new long[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        this.array[1] = new long[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    @Obfuscate
    public void setVal(int i, int j, long val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Long>> test()
    {
        ArrayList<ArrayList<Long>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k,l,10000000000L);
        //assert that also the rest of the array is unchanged
        long[][] native_array = array;
        for(int i=0;i<native_array.length;i++)
        {
            ArrayList<Long> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
