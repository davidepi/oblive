package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeInterfaceBoolean
{
    public CatchInvokeInterfaceBoolean()
    {

    }

    @Obfuscate
    public int div(DivisionInterface interf, boolean a)
    {
      int res = 0;
      try
      {
        res+= interf.div(a)?1:0;
        res++;
      }
      catch(Exception e)
      {
        res+=1000;
      }
      return res;
    }
}
