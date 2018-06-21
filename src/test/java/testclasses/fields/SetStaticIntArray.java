package testclasses.fields;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class SetStaticIntArray
{
    private static int[] array;
    private int[] array2;

    public SetStaticIntArray()
    {
        this.array2 = new int[]{9, 6, 5, 4, 3, 2, 1, 8, 7};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void setArray()
    {
        this.array = array2;
    }

    ;

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        this.setArray();
        int[] native_array = this.array;
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }

}
