package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class StoreArrayFloat
{
    private float[][] array;

    public StoreArrayFloat()
    {
        this.array = new float[2][10];
        this.array[0] = new float[]{-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f};
        this.array[1] = new float[]{-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f,-1.f};
    }

    @Obfuscate
    public void setVal(int i, int j, float val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Float>> test()
    {
        ArrayList<ArrayList<Float>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k,l,13.5f);
        //assert that also the rest of the array is unchanged
        float[][] native_array = array;
        for(int i=0;i<native_array.length;i++)
        {
            ArrayList<Float> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
