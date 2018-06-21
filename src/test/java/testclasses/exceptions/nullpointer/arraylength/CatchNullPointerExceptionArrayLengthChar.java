package testclasses.exceptions.nullpointer.arraylength;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassChar;

public class CatchNullPointerExceptionArrayLengthChar
{

    public CatchNullPointerExceptionArrayLengthChar()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassChar obj)
    {

        int res = 0;
        try
        {
            res = obj.b.length;
            res += 1000;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            res = obj.b.length;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
