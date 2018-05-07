package testclasses.exceptions.invoke.invokeinterface;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchInvokeInterfaceObject
{
    public CatchInvokeInterfaceObject()
    {

    }

    @Obfuscation
    public int concatenate(DivisionInterface interf, String a)
    {
      int res = 0;
      try
      {
        res+= interf.div(a).length();
        res++;
      }
      catch(Exception e)
      {
        res+=1000;
      }
      return res;
    }
}
