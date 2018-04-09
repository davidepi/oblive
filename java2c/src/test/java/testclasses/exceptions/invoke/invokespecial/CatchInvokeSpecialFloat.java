package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeSpecialFloat extends InvokeVirtualFloat
{
    public CatchInvokeSpecialFloat()
    {

    }

    @Obfuscate
    @Override
    public float add(float a, float b)
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
      return (float)res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public float normalAdd(float a, float b)
    {
        return (a - b);
    }
}
