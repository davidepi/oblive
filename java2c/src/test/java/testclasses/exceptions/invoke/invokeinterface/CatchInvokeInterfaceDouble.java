package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchInvokeInterfaceDouble
{
    public CatchInvokeInterfaceDouble()
    {

    }

    @Obfuscation
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
