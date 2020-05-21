package it.oblive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
     */
    public void dispose() {
        try {
            Files.walk(unpackDir)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException ignored) {
        }
    }

    /**
     * Extract files from a zip file
     *
     * @param source       The source zip file
     * @param targetFolder The folder where the content will be extracted
     * @throws IOException if the zip file is not readable or the target folder not writable
     */
    protected static void unzip(final File source, Path targetFolder) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(source));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            Path fullPath = targetFolder.resolve(entry.getName());
            if (entry.isDirectory()) {
                Files.createDirectories(fullPath);
            } else {
                //this will always be a fresh directory, so no problem with REPLACE_EXISTING
                //but somehow I managed to create a zip file containing two files with the same name and this would
                //throw an unwanted exception (given that they have the same content)
                Files.copy(zis, fullPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
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
