package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class MonitorMethod {

    private static Integer a = 0;
    private static final Object lock = new Object();

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public void exec() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (MonitorMethod.lock) {
                MonitorMethod.a++;
            }
        }
    }

    public int test() {
        Runnable r = () -> new MonitorMethod().exec();
        Thread t1 = new Thread(r);
        t1.start();
        for (int i = 0; i < 1000000; i++)
            synchronized (MonitorMethod.lock) {
                MonitorMethod.a++;
            }
        try {

            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int retval = MonitorMethod.a;
        MonitorMethod.a = 0;
        return retval;
    }
}
