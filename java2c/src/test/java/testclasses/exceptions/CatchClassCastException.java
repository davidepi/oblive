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
        String retval = "";
        try
        {
            retval = (String)a;
        }
        catch(ClassCastException e)
        {
            retval += "wrong ";
        }

        try
        {
            retval = (String)a;
        }
        catch(RuntimeException e)
        {
            retval += "type ";
        }

        try
        {
            retval = (String)a;
        }
        catch(Exception e)
        {
            retval += "exception ";
        }

        try
        {
            retval = (String)a;
        }
        catch(Throwable e)
        {
            retval += "! ";
        }

        return retval;
    }
}
