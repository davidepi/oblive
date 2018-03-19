package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayBooleanSingleDim
{
    private boolean[] array;

    public StoreArrayBooleanSingleDim()
    {
        this.array = new boolean[]{false,false,false,true,false,true,false,false,false,false};
    }

    @Obfuscate
    public void setVal(int i, boolean val)
    {
        this.array[i] = val;
    }

    public ArrayList<Boolean> test()
    {
        ArrayList<Boolean> retval = new ArrayList<>();
        int i = 4;
        this.setVal(i,true);
        //assert that also the rest of the array is unchanged
        for(int j=0;j<this.array.length;j++)
            retval.add(array[j]);
        return retval;
    }

}
