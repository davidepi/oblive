package testclasses;

import it.se.obfuscator.Obfuscate;
import org.junit.Test;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class MonitorMethod
{
    static Integer a = 0;
    public MonitorMethod()
    {

    }

    @Obfuscate
    public void exec() throws InterruptedException
    {
        synchronized(this)
        {
            MonitorMethod.a++;
            sleep(2000);
        }
    }

    @Test
    public int test()
    {
        /* This doesn't work even in non obfuscated java, but only with the testing framework :thinking: */
        ExecutorService executor = Executors.newCachedThreadPool();
        MonitorMethod testme = new MonitorMethod();
        Callable<Object> task = new Callable<Object>() {
            public Object call() throws InterruptedException
            {
                testme.exec();
                return MonitorMethod.a;
            }
        };
        Future<Object> future1 = executor.submit(task);
        Future<Object> future2 = executor.submit(task);
        Future<Object> future3 = executor.submit(task);
        Future<Object> future4 = executor.submit(task);
        Future<Object> future5 = executor.submit(task);
        try
        {
            future1.get(1, TimeUnit.SECONDS);
            future2.get(1, TimeUnit.SECONDS);
            future3.get(1, TimeUnit.SECONDS);
            future4.get(1, TimeUnit.SECONDS);
            future5.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException | InterruptedException | ExecutionException ex)
        {
            // handle the timeout
        } finally {
            future2.cancel(true);
            future3.cancel(true);
            future4.cancel(true);
            future5.cancel(true);
            future1.cancel(true);
        }
        return MonitorMethod.a;
    }
}
