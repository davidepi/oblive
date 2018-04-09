package testclasses.exceptions.invoke.invokespecial;

import it.se.obfuscator.Obfuscate;

public class CatchInvokeSpecialObject extends InvokeVirtualObject
{
    public CatchInvokeSpecialObject()
    {

    }

    @Obfuscate
    @Override
    public String concatenate(String a, char b)
    {
      int res = 0;
      try
      {
        super.normalcat(a,b);
        res+=1000;
      }
      catch(Exception e)
      {
        res++;
      }
      return ((Integer)res).toString();
    }

    //wrong method, I want the one of the superclass to be called -> invokespecial
    public String normalcat(String a, char b)
    {
        return "WRONG INVOKESPECIAL!";
    }
}
