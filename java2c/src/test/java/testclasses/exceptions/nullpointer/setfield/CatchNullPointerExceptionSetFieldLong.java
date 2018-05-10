package testclasses.exceptions.nullpointer.setfield;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassLong;

public class CatchNullPointerExceptionSetFieldLong
{

    public CatchNullPointerExceptionSetFieldLong()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassLong obj)
    {
        int res = 0;
        try
        {
            obj.a = 0;
            res += 1000;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.a = 0;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
