package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class NestedCatchClassCastException
{
    public NestedCatchClassCastException()
    {

    }

    @Obfuscate
    public static String castString(Object a)
    {
        String retval = "";
        try
        {
            try
            {
                retval = (String)a;
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
