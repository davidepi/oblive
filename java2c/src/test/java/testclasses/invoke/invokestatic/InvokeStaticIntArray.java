package testclasses.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class InvokeStaticIntArray
{
    public InvokeStaticIntArray()
    {

    }

    @Obfuscate
    public int[] exec()
    {
        return testclasses.invoke.invokestatic.InvokeStaticIntArray.returnArray();
    }

    public static int[] returnArray()
    {
        return new int[]{1,2,3,4,5,6,7,8,9,10};
    }

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.exec();
        for(int i=0;i<native_array.length;i++)
            res.add(native_array[i]);
        return res;
    }
}