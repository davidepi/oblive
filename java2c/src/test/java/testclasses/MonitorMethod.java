package testclasses;

import it.se.obfuscator.Obfuscate;

import static java.lang.Thread.sleep;

public class MonitorMethod
{
    static int a;

    public MonitorMethod()
    {

    }

    @Obfuscate
    public int add() throws InterruptedException
    {
        synchronized (this)
        {
            MonitorMethod.a++;
            sleep(2000);
        }
        return MonitorMethod.a;
    }
}
