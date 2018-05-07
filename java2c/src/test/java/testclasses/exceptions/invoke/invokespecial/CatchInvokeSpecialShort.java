package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchInvokeSpecialShort extends InvokeVirtualShort
{
    public CatchInvokeSpecialShort()
    {

    }

    @Obfuscation
    @Override
    public short add(short a, short b)
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
      return (short)res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public short normalAdd(short a, short b)
    {
        return (short)(a - b);
    }
}
