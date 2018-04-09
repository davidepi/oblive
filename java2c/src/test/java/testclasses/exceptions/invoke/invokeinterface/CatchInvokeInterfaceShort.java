package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeInterfaceShort
{
    public CatchInvokeInterfaceShort()
    {

    }

    @Obfuscate
    public int div(DivisionInterface interf, short a)
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
