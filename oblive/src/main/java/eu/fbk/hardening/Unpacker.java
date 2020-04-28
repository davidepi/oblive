package eu.fbk.hardening;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import static java.nio.file.Files.createTempDirectory;

/**
 * Class providing the skeleton and some utilities for unpacking several artifacts (like Jar and Apk).
 * This class uses a temporary folder to store the extracted file and thus it should be cleaned with the dispose()
 * method()
 *
 * @author D.Pizzolotto
 */
public abstract class Unpacker {
    // prefix for the temp dir
    private static final String tempDirPrefix = "UPKOBL_";
    /**
     * Temporary directory where the content of the artifact will be extracted
     */
    protected Path unpackDir;

    /**
     * Constructor, using the system's default temporary directory. Note that a subdirectory will be created.
     *
     * @throws IOException in case the creation of the subdirectory fails
     */
    Unpacker() throws IOException {
        Path systemTempDir = Paths.get(System.getProperty("java.io.tmpdir"));
        this.unpackDir = createTempDirectory(systemTempDir, tempDirPrefix);
    }

    /**
     * Constructor, using the user provided temporary directory. Note that a subdirectory will be created anyway.
     *
     * @param outdir The used provided temporary directory
     * @throws IOException in case the creation of the subdirectory fails
     */
    Unpacker(Path outdir) throws IOException {
        this.unpackDir = createTempDirectory(outdir, tempDirPrefix);
    }

    /**
     * Returns the root directory of the extracted files
     *
     * @return A Path pointing to the extracted files
     */
    public final Path getUnpackDir() {
        return unpackDir;
    }

    /**
     * Delete the temporary folder
     *
     * @throws IOException if the temporary folder cannot be read (unlikely, but maybe due to changed permissions)
     */
    public void dispose() throws IOException {
        Files.walk(unpackDir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }

    /**
     * Extract files from a zip file
     *
     * @param source       The source zip file
     * @param targetFolder The folder where the content will be extracted
     * @throws IOException if the zip file is not readable or the target folder not writable
     */
    protected static void unzip(final File source, Path targetFolder) throws IOException {
        // strictly taken from "https://stackoverflow.com/questions/10633595/java-zip-how-to-unzip-folder" :D
        ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {
            File file = new File(String.valueOf(targetFolder), entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                File parent = file.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buffer = new byte[Math.toIntExact(entry.getSize())];
                int location;
                while ((location = zis.read(buffer)) != -1) {
                    bos.write(buffer, 0, location);
                }
            }
            entry = zis.getNextEntry();
        }
        zis.close();
    }

    /**
     * Recreate a zip file given the content of a folder
     *
     * @param sourceFolder The folder containing the files that will be used. The folder itself won't be added
     * @param targetZip    A path to the output zip file
     * @throws IOException if the output zip file is not writable of the source folder is not readable
     */
    protected static void rezip(final Path sourceFolder, File targetZip) throws IOException {
        // and this one from "https://stackoverflow.com/questions/1091788/how-to-create-a-zip-file-in-java"
        final ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(targetZip));
        Files.walkFileTree(sourceFolder, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
                try {
                    Path targetFile = sourceFolder.relativize(file);
                    outputStream.putNextEntry(new ZipEntry(targetFile.toString()));
                    byte[] bytes = Files.readAllBytes(file);
                    outputStream.write(bytes, 0, bytes.length);
                    outputStream.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return FileVisitResult.CONTINUE;
            }
        });
        outputStream.close();
    }

    /**
     * Unpack the current artifact to the temporary folder
     *
     * @param input the current artifact
     * @throws IOException if the current artifact cannot be read
     */
    public abstract void unpack(final File input) throws IOException;

    /**
     * Repack the temporary folder into a new artifact
     *
     * @param output the new artifact that will be created
     * @throws IOException if the artifact cannot be created
     */
    public abstract void repack(File output) throws IOException;
}
