package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayByte
{
    private byte[][] array;

    public StoreArrayByte()
    {
        this.array = new byte[2][10];
        this.array[0] = new byte[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        this.array[1] = new byte[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }

    @Obfuscate
    public void setVal(int i, int j, byte val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Byte>> test()
    {
        ArrayList<ArrayList<Byte>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k,l,(byte)100);
        //assert that also the rest of the array is unchanged
        byte[][] native_array = array;
        for(int i=0;i<native_array.length;i++)
        {
            ArrayList<Byte> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
