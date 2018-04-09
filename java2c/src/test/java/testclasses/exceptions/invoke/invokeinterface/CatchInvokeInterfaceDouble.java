package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeInterfaceDouble
{
    public CatchInvokeInterfaceDouble()
    {

    }

    @Obfuscate
    public int div(DivisionInterface interf, double a)
    {
      int res = 0;
      try
      {
        res+= interf.div(a);
        res++;
      }
      catch(Exception e)
      {
        res+=1000;
      }
      return res;
    }
}
