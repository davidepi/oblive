package testclasses.exceptions.invoke.invokespecial;

import eu.fbk.hardening.annotation.Obfuscation;

public class CatchInvokeSpecialByte extends InvokeVirtualByte
{
    public CatchInvokeSpecialByte()
    {

    }

    @Obfuscation
    @Override
    public byte add(byte a, byte b)
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
      return (byte)res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public byte normalAdd(byte a, byte b)
    {
        return (byte)(a - b);
    }
}
