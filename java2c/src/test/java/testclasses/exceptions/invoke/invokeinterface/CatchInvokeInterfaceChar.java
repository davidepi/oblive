package testclasses.exceptions.invoke.invokeinterface;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeInterfaceChar
{
    public CatchInvokeInterfaceChar()
    {

    }

    @Obfuscate
    public int div(DivisionInterface interf, char a)
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
