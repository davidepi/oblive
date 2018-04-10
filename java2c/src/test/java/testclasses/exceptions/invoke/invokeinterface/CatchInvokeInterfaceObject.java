package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeInterfaceObject
{
    public CatchInvokeInterfaceObject()
    {

    }

    @Obfuscate
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