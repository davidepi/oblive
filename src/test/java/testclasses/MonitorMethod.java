package testclasses;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class MonitorMethod {

    private static final Object lock = new Object();
    private static Integer a = 0;

    @NativeObfuscation
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
        return MonitorMethod.a;
    }
}
