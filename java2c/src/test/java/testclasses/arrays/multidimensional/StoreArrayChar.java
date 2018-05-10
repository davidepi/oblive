package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class StoreArrayChar
{
    private char[][] array;

    public StoreArrayChar()
    {
        this.array = new char[2][10];
        this.array[0] = new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        this.array[1] = new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setVal(int i, int j, char val)
    {
        this.array[i][j] = val;
    }

    public ArrayList<ArrayList<Character>> test()
    {
        ArrayList<ArrayList<Character>> retval = new ArrayList<>();
        int k = 1;
        int l = 4;
        this.setVal(k, l, 'あ');
        //assert that also the rest of the array is unchanged
        char[][] native_array = array;
        for (int i = 0; i < native_array.length; i++)
        {
            ArrayList<Character> current = new ArrayList<>(3);
            retval.add(current);

        }
        return retval;
    }

}
