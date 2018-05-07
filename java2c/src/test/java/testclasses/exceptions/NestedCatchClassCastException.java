package testclasses.exceptions;

import eu.fbk.hardening.annotation.Obfuscation;

public class NestedCatchClassCastException
{
    public NestedCatchClassCastException()
    {

    }

    @Obfuscation
    public static String castString(Object a)
    {
        String retval = "";
        try
        {
            try
            {
                retval = (String)a;
                retval+="a";
            }
            catch (ClassCastException e)
            {
                retval = "wrongest input type";
            }
            retval = (String) a;
        }
        catch(ClassCastException e)
        {
            retval += "wrong input type";
        }
        catch(Throwable e)
        {
            retval = "ouch";
        }
        return retval;
    }
}
