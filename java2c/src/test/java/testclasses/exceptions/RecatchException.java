package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class RecatchException
{
    public RecatchException()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            throw new ClassCastException();
        }
        catch(ClassCastException e)
        {
            try
            {
                throw null;
            }
            catch(NullPointerException e1)
            {
                try
                {
                    throw new ClassCastException();
                }
                catch (ClassCastException e2)
                {
                    res=1000;
                }
            }
        }
        return res;
    }
}
