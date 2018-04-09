package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeSpecialChar extends InvokeVirtualChar
{
    public CatchInvokeSpecialChar()
    {

    }

    @Obfuscate
    @Override
    public char add(char a, char b)
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
      return (char)res;
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public char normalAdd(char a, char b)
    {
        return (char)(a - b);
    }
}
