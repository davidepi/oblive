package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchInvokeInterfaceObject
{
    public CatchInvokeInterfaceObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int concatenate(DivisionInterface interf, String a)
    {
        int res = 0;
        try
        {
            res += interf.div(a).length();
            res++;
        } catch (Exception e)
        {
            res += 1000;
        }
        return res;
    }
}
