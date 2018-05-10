package testclasses.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

import java.util.ArrayList;

public class InvokeInterfaceIntArray
{
    public InvokeInterfaceIntArray()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int[] exec(AdderInterface interf)
    {
        return interf.array();
    }

    public ArrayList<Integer> test()
    {
        ArrayList<Integer> res = new ArrayList<Integer>(10);
        int[] native_array = this.exec(new ImplementedInterface());
        for (int i = 0; i < native_array.length; i++)
            res.add(native_array[i]);
        return res;
    }
}