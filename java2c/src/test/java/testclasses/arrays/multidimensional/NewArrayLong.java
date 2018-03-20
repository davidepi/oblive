package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class NewArrayLong
{
    public NewArrayLong()
    {

    }

    @Obfuscate
    public long[][] getArray()
    {
        return new long[2][3];
    }

    public ArrayList<ArrayList<Long>> test()
    {
        ArrayList<ArrayList<Long>> res = new ArrayList<>(2);
        long[][] native_array = this.getArray();
        for(int i=0;i<native_array.length;i++)
        {
            ArrayList<Long> current = new ArrayList<>(3);
            res.add(current);

        }
        return res;
    }

}
