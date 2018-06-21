package testclasses.exceptions.nullpointer;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchThrowedNullException
{
    public CatchThrowedNullException()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        int res = 0;
        try
        {
            throw null;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            throw null;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            throw null;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            throw null;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
