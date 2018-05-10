package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class NestedCatchClassCastException
{
    public NestedCatchClassCastException()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public static String castString(Object a)
    {
        String retval = "";
        try
        {
            try
            {
                retval = (String) a;
                retval += "a";
            } catch (ClassCastException e)
            {
                retval = "wrongest input type";
            }
            retval = (String) a;
        } catch (ClassCastException e)
        {
            retval += "wrong input type";
        } catch (Throwable e)
        {
            retval = "ouch";
        }
        return retval;
    }
}
