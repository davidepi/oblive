package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchClassCastException
{
    public CatchClassCastException()
    {

    }

    @Obfuscate
    public static String castString(Object a)
    {
        String retval;
        try
        {
            retval = (String)a;
        }
        catch(ClassCastException e)
        {
            retval = "wrong input type";
        }
        catch(NullPointerException e)
        {
            retval = "";
        }
        return retval;
    }
}
