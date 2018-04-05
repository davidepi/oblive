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
            retval+="a";
        }
        catch(ClassCastException e)
        {
            retval += "wrong ";
        }

        try
        {
            retval = (String)a;
            retval+="b";
        }
        catch(RuntimeException e)
        {
            retval += "type ";
        }

        try
        {
            retval = (String)a;
            retval+="c";
        }
        catch(Exception e)
        {
            retval += "exception ";
        }

        try
        {
            retval = (String)a;
            retval+="d";
        }
        catch(Throwable e)
        {
            retval += "! ";
        }

        return retval;
    }
}
