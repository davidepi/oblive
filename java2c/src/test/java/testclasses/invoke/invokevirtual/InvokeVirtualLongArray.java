package testclasses.invoke.invokevirtual;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class InvokeVirtualLongArray
{
    public InvokeVirtualLongArray()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public long[] exec()
    {
        return returnArray();
    }

    public long[] returnArray()
    {
        return new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    public ArrayList<Long> test()
    {
        ArrayList<Long> res = new ArrayList<Long>(10);
        long[] native_array = this.exec();
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }
}