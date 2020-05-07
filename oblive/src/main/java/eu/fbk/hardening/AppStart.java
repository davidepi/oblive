package eu.fbk.hardening;

import eu.fbk.hardening.support.NativeCompiler;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.createTempDirectory;

public class AppStart {

    private static final String PREFIX = "OBLCC_";

    public static void main(String[] args) {
        if (args.length != 2 && args.length != 3) {
            System.err.println("Usage: <input jar file> <output name>.jar [libname]");
            System.exit(1);
        }
        File inputJar = new File(args[0]);
        if (!inputJar.exists()) {
            System.err.println("The input file " + args[0] + " does not exist.");
            System.exit(1);
        }
        String libname;
        if (args.length == 3) {
            libname = args[2];
        } else {
            libname = "native";
        }
        Unpacker jar = null;
        JavaToC j2c = new JavaToC();
        Path fullpath = Paths.get(args[1]).toAbsolutePath();
        if (!String.valueOf(fullpath).endsWith(".jar")) {
            System.err.println("The output file should end with .jar!");
            System.exit(1);
        }
        if (Files.exists(fullpath)) {
            System.err.println("The output jar is already existing and won't be replaced");
            System.exit(1);
        }
        Path outdir = fullpath.getParent();
        File outJar = new File(String.valueOf(fullpath));
        File sharedLib = new File(outdir + File.separator + "lib" + libname + ".so");
        if (sharedLib.exists()) {
            System.err.println("The output path already contains a file lib" + libname + ".so and won't be replaced");
            System.exit(1);
        }
        try {
            Path tempdir = createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), PREFIX);
            File outLibSource = new File(tempdir + File.separator + "lib" + libname + ".c");
            jar = new UnpackerJar();
            jar.unpack(inputJar);
            int[] analyzed = {0};
            long[] ttime = {0};
            j2c.startParsing(String.valueOf(jar.getUnpackDir()), outLibSource);
            Files.walkFileTree(jar.getUnpackDir(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                    if (file.toString().endsWith(".class")) {
                        analyzed[0]++;
                        long t0 = System.currentTimeMillis();
                        j2c.parseClass(file.toString());
                        long t1 = System.currentTimeMillis();
                        ttime[0] += t1 - t0;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            j2c.endParsing();
            System.out.println("Analyzed " + analyzed[0] + " files in " + (double) ttime[0] * 1.f / 1000.f + "ms");
            jar.repack(outJar);
            // compile
            File inputSource = new File(tempdir + File.separator + "lib"+libname+".c");
            File objectFile = new File(tempdir + File.separator + "lib"+libname+".o");
            NativeCompiler compiler = new NativeCompiler();
            compiler.compileFile(new File[]{inputSource}, objectFile);
            compiler.compileSharedLib(new File[]{objectFile}, sharedLib);
            jar.dispose();
            Files.walk(tempdir).filter(Files::isRegularFile).map(Path::toFile).forEach(File::delete);
            Files.delete(tempdir);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            jar.dispose();
        }
    }
}
