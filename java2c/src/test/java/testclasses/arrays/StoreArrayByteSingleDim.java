package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayByteSingleDim
{
    private byte[] array;

    public StoreArrayByteSingleDim()
    {
        this.array = new byte[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    @Obfuscate
    public void setVal(int i, byte val)
    {
        this.array[i] = val;
    }

    public ArrayList<Byte> test()
    {
        ArrayList<Byte> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i,(byte)100);
        //assert that also the rest of the array is unchanged
        for(int j=0;j<this.array.length;j++)
            retval.add(array[j]);
        return retval;
    }

}
