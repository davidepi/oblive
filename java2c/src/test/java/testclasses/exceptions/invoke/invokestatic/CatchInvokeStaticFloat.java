package testclasses.exceptions.invoke.invokestatic;

import eu.fbk.hardening.annotation.Obfuscation;
import testclasses.exceptions.UserDefinedException;

public class CatchInvokeStaticFloat
{
    public CatchInvokeStaticFloat()
    {

    }

    @Obfuscation
    public int div(int a)
    {
        int res = 0;
        try
        {
            res = (int)normalDiv(a,0);
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

    public static float normalDiv(int a, int b)
    {
        return (float)(a / b);
    }

    public void other() throws UserDefinedException
    {
        throw new UserDefinedException();
    }
}
