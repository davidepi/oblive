package eu.fbk.hardening.support;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSystemInfo {

    private static int os;

    @BeforeClass
    public static void getOS() {
        String osname = System.getProperty("os.name");
        switch (osname) {
            case "Mac OS X":
                os = 1;
                break;
            case "Linux":
                os = 2;
                break;
            default:
                throw new UnsupportedOperationException("OS " + osname + " not recognized");
        }
    }

    @Test
    public void osDetectTest() {
        switch (os) {
            case 0:
                Assert.assertTrue(SystemInfo.isWindows());
                Assert.assertFalse(SystemInfo.isMacOS());
                Assert.assertFalse(SystemInfo.isLinux());
                Assert.assertFalse(SystemInfo.isNix());
                break;
            case 1:
                Assert.assertFalse(SystemInfo.isWindows());
                Assert.assertTrue(SystemInfo.isMacOS());
                Assert.assertFalse(SystemInfo.isLinux());
                Assert.assertTrue(SystemInfo.isNix());
                break;
            case 2:
                Assert.assertFalse(SystemInfo.isWindows());
                Assert.assertFalse(SystemInfo.isMacOS());
                Assert.assertTrue(SystemInfo.isLinux());
                Assert.assertTrue(SystemInfo.isNix());
                break;
            default:
                //should never end here
                Assert.fail();
        }
    }

    @Test
    public void whichTest() {
        switch (os) {
            case 0://TODO: Implement windows tests.
                Assert.fail();
                break;
            case 1:
            case 2:
                String res = SystemInfo.which("ls");
                Assert.assertEquals("/bin/ls", res);
                res = SystemInfo.which("invented command");
                Assert.assertNull(res);
                break;
        }
    }
}
