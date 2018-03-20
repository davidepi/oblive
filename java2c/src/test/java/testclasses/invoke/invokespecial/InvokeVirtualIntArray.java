package testclasses.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

import java.util.ArrayList;

public class InvokeVirtualIntArray
{
    public InvokeVirtualIntArray()
    {

    }

    @Obfuscate
    public int[] exec()
    {
        return returnArray();
    }

    public int[] returnArray()
    {
        return new int[]{1,2,3,4,5,6,7,8,9,10};
    }
}