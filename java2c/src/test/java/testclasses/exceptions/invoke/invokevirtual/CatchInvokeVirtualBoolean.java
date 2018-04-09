package testclasses.exceptions.invoke.invokevirtual;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeVirtualBoolean
{
    public CatchInvokeVirtualBoolean()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        int res = 0;
        try
        {
            res = normalDiv(a,0)?1:0;
        }
        catch (ArithmeticException e0)
        {
            try
            {
                other();
                res+=1000;
            }
            catch (UserDefinedException e1)
            {
                res++;
            }
            catch (Exception e)
            {
                res-=10000;
            }
        }
        return res;
    }

    public boolean normalDiv(int a, int b)
    {
        return (a / b)>0?true:false;
    }

    public void other() throws UserDefinedException
    {
        throw new UserDefinedException();
    }
}