package eu.fbk.hardening.support;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestSystemInfo {

    private static int os;

    @BeforeAll
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
                Assertions.assertTrue(SystemInfo.isWindows());
                Assertions.assertFalse(SystemInfo.isMacOS());
                Assertions.assertFalse(SystemInfo.isLinux());
                Assertions.assertFalse(SystemInfo.isNix());
                break;
            case 1:
                Assertions.assertFalse(SystemInfo.isWindows());
                Assertions.assertTrue(SystemInfo.isMacOS());
                Assertions.assertFalse(SystemInfo.isLinux());
                Assertions.assertTrue(SystemInfo.isNix());
                break;
            case 2:
                Assertions.assertFalse(SystemInfo.isWindows());
                Assertions.assertFalse(SystemInfo.isMacOS());
                Assertions.assertTrue(SystemInfo.isLinux());
                Assertions.assertTrue(SystemInfo.isNix());
                break;
            default:
                //should never end here
                Assertions.fail();
        }
    }

    @Test
    public void whichTest() {
        switch (os) {
            case 0://TODO: Implement windows tests.
                Assertions.fail();
                break;
            case 1:
            case 2:
                String res = SystemInfo.which("ls");
                Assertions.assertEquals("/bin/ls", res);
                res = SystemInfo.which("invented command");
                Assertions.assertNull(res);
                break;
        }
    }
}
