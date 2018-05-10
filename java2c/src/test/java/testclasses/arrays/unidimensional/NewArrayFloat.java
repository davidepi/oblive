package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayFloat
{
    public NewArrayFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public float[] getArray()
    {
        return new float[10];
    }

    public ArrayList<Float> test()
    {
        ArrayList<Float> res = new ArrayList<Float>(10);
        float[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
