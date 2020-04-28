package eu.fbk.hardening;

import eu.fbk.hardening.support.NativeCompiler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppStart {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Missing arguments: <input jar file> <output name>.jar");
            System.exit(1);
        }
        File inputJar = new File(args[0]);
        if (!inputJar.exists()) {
            System.err.println("The input file " + args[0] + " does not exist.");
            System.exit(1);
        }
        Unpacker jar = null;
        JavaToC j2c = new JavaToC();
        Path fullpath = Paths.get(args[1]).toAbsolutePath();
        if (!String.valueOf(fullpath).endsWith(".jar")) {
            System.err.println("The output file should end with .jar!");
            System.exit(1);
        }
        Path outdir = fullpath.getParent();
        try {
            jar = new UnpackerJar();
            File outJar = new File(String.valueOf(fullpath));
            File outLibSource = new File(outdir + File.separator + "libnative.c");
            jar.unpack(inputJar);
            int[] analyzed = {0};
            long[] ttime = {0};
            j2c.startParsing(String.valueOf(jar.getUnpackDir()), outLibSource);
            Files.walk(Paths.get(args[0])).forEach(a -> {
                if (a.toString().endsWith(".class")) {
                    try {
                        analyzed[0]++;
                        long t0 = System.currentTimeMillis();
                        j2c.parseClass(a.toString());
                        long t1 = System.currentTimeMillis();
                        ttime[0] += t1 - t0;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            j2c.endParsing();
            System.out.println("Analyzed " + analyzed[0] + " files in " + (double) ttime[0] * 1.f / 1000.f + "ms");
            jar.repack(outJar);
            // compile
            File inputSource = new File(outdir + File.separator + "libnative.c");
            File objectFile = new File(outdir + File.separator + "libnative.o");
            File sharedLib = new File(outdir + File.separator + "libnative.so");
            NativeCompiler compiler = new NativeCompiler();
            compiler.compileFile(new File[]{inputSource}, objectFile);
            compiler.compileSharedLib(new File[]{objectFile}, sharedLib);
            inputSource.delete();
            objectFile.delete();
            jar.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            jar.dispose();
        }
    }
}
