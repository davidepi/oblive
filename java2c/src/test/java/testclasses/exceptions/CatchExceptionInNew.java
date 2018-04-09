package testclasses.exceptions;

import it.se.obfuscator.Obfuscate;

public class CatchExceptionInNew
{
    public CatchExceptionInNew()
    {

    }

    @Obfuscate
    public int exec()
    {
        int res = 0;
        try
        {
            new ClassExceptionInInit();
            res+=1000;
        }
        catch(Exception e)
        {
            res++;
        }
        return 0;
    }
}
