package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassInt;

public class CatchNullPointerExceptionXSTOREInt
{

    public CatchNullPointerExceptionXSTOREInt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassInt obj)
    {
        int res = 0;
        try
        {
            obj.b[1] = 1;
            res += 1000;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 1;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = 0;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
