package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class NewArrayCharThreeDims
{
    public NewArrayCharThreeDims()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public char[][][] getArray()
    {
        return new char[2][3][4];
    }

    public ArrayList<ArrayList<ArrayList<Character>>> test()
    {
        ArrayList<ArrayList<ArrayList<Character>>> res = new ArrayList<>(2);
        char[][][] native_array = this.getArray();
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<ArrayList<Character>> current = new ArrayList<>(3);
            for (int j = 0; j < native_array[i].length; j++)
            {
                current.add(new ArrayList<Character>(4));
            }
            res.add(current);
        }
        return res;
    }

}
