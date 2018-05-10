package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayBoolean
{
    public NewArrayBoolean()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean[] getArray()
    {
        return new boolean[10];
    }

    public ArrayList<Boolean> test()
    {
        ArrayList<Boolean> res = new ArrayList<Boolean>(10);
        boolean[] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
