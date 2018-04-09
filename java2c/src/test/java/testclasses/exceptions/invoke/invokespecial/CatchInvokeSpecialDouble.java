package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeSpecialDouble extends InvokeVirtualDouble
{
    public CatchInvokeSpecialDouble()
    {

    }

    @Obfuscate
    @Override
    public double add(double a, double b)
    {
      int res = 0;
      try
      {
        super.normalAdd(a,b);
        res+=1000;
      }
      catch(Exception e)
      {
        res++;
      }
      return (double)res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public double normalAdd(double a, double b)
    {
        return (a - b);
    }
}
