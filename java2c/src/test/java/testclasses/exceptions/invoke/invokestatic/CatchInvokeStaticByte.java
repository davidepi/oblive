package testclasses.exceptions.invoke.invokestatic;

import it.se.obfuscator.Obfuscate;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeStaticByte
{
    public CatchInvokeStaticByte()
    {

    }

    @Obfuscate
    public int div(int a)
    {
        int res = 0;
        try
        {
            res = CatchInvokeStaticByte.normalDiv(a,0);
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

    public static byte normalDiv(int a, int b)
    {
        return (byte)(a / b);
    }

    public void other() throws UserDefinedException
    {
        throw new UserDefinedException();
    }
}