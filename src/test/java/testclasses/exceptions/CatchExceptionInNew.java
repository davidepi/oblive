package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchExceptionInNew
{
    public CatchExceptionInNew()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        int res = 0;
        try
        {
            new ClassExceptionInInit();
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }
        return 0;
    }
}
