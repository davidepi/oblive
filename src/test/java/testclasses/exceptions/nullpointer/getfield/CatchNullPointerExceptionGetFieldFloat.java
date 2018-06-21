package testclasses.exceptions.nullpointer.getfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassFloat;

public class CatchNullPointerExceptionGetFieldFloat
{

    public CatchNullPointerExceptionGetFieldFloat()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassFloat obj)
    {
        int res = 0;
        try
        {
            res += (int) obj.a;
            res += 1000;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            res += (int) obj.a;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            res += (int) obj.a;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            res += (int) obj.a;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
