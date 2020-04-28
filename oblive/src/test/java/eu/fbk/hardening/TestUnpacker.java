package eu.fbk.hardening;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestUnpacker {

    @Test
    public void testUnpackerJarUnpack() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("annotations-1.0.0.jar");
        Assertions.assertNotNull(url);
        File jarFile = new File(url.getPath());
        try {
            UnpackerJar jar = new UnpackerJar();
            Path dir = jar.getUnpackDir();
            Assertions.assertFalse(Files.list(dir).findAny().isPresent());
            jar.unpack(jarFile);
            Assertions.assertTrue(Files.list(dir).findAny().isPresent());
            jar.dispose();
            Assertions.assertFalse(Files.exists(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnpackerJarRepack() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("annotations-1.0.0.jar");
        Assertions.assertNotNull(url);
        File jarFile = new File(url.getPath());
        try {
            UnpackerJar jar = new UnpackerJar();
            Path dir = jar.getUnpackDir();
            Assertions.assertFalse(Files.list(dir).findAny().isPresent());
            jar.unpack(jarFile);
            Assertions.assertTrue(Files.list(dir).findAny().isPresent());
            File output = new File("/tmp/annotations-1.0.0.zip");
            jar.repack(output);
            jar.dispose();
            Assertions.assertFalse(Files.exists(dir));
            Assertions.assertTrue(output.exists());
            output.delete();
            Assertions.assertFalse(output.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
