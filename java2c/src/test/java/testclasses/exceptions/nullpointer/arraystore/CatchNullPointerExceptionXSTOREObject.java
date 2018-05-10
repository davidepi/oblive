package testclasses.exceptions.nullpointer.arraystore;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class CatchNullPointerExceptionXSTOREObject
{

    public CatchNullPointerExceptionXSTOREObject()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public int exec(SupportClassObject obj)
    {
        int res = 0;
        try
        {
            obj.b[1] = "str0";
            res += 1000;
        } catch (NullPointerException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = "str1";
            res += 1000;
        } catch (RuntimeException e)
        {
            res++;
        }

        try
        {
            obj.b[1] = "str2";
            res += 1000;
        } catch (Exception e)
        {
            res++;
        }

        try
        {
            obj.b[1] = "str3";
            res += 1000;
        } catch (Throwable e)
        {
            res++;
        }

        return res;
    }
}
