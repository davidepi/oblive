package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeSpecialInt extends InvokeVirtualInt
{
    public CatchInvokeSpecialInt()
    {

    }

    @Obfuscate
    @Override
    public int add(int a, int b)
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
      return res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public int normalAdd(int a, int b)
    {
        return a - b;
    }
}
