package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchInvokeSpecialBoolean extends InvokeVirtualBoolean
{
    public CatchInvokeSpecialBoolean()
    {

    }

    @Obfuscation
    @Override
    public boolean and(boolean a, boolean b)
    {
      int res = 0;
      try
      {
        super.normalAnd(a,b);
        res+=1000;
      }
      catch(Exception e)
      {
        res++;
      }
      return res==1;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public boolean normalAnd(boolean a, boolean b)
    {
        return false;
    }
}
