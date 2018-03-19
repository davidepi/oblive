package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayFloatSingleDim
{
    public NewArrayFloatSingleDim()
    {

    }

    @Obfuscate
    public float[] getArray()
    {
        return new float[10];
    }

    public ArrayList<Float> test()
    {
        ArrayList<Float> res = new ArrayList<Float>(10);
        float[] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }

}
