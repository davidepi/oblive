package testclasses.exceptions.outofbounds.arrayload;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class CatchArrayLoadOutOfBoundsBoolean
{
    private boolean array[];

    public CatchArrayLoadOutOfBoundsBoolean()
    {
        this.array = new boolean[2];
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec()
    {
        int res = 0;

        try
        {
            res += this.array[2] ? 1 : 0;
            res += 1000;
        } catch (ArrayIndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            res += this.array[2] ? 1 : 0;
            res += 1000;
        } catch (IndexOutOfBoundsException e)
        {
            res++;
        }

        try
        {
            res += this.array[2] ? 1 : 0;
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            res += this.array[2] ? 1 : 0;
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            res += this.array[2] ? 1 : 0;
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
