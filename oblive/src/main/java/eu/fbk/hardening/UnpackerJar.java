package eu.fbk.hardening;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Class used to unpack and repack Jar artifacts
 * This class uses a temporary folder to store the extracted file and thus it should be cleaned with the dispose()
 * method()
 *
 * @author D.Pizzolotto
 */
public class UnpackerJar extends Unpacker {

    /**
     * Constructor, using the system's default temporary directory. Note that a subdirectory will be created.
     *
     * @throws IOException in case the creation of the subdirectory fails
     */
    public UnpackerJar() throws IOException {
        super();
    }

    /**
     * Constructor, using the user provided temporary directory. Note that a subdirectory will be created anyway.
     *
     * @param outdir The used provided temporary directory
     * @throws IOException in case the creation of the subdirectory fails
     */
    public UnpackerJar(Path outdir) throws IOException {
        super(outdir);
    }

    @Override
    public void unpack(final File input) throws IOException {
        unzip(input, getUnpackDir());
    }

    @Override
    public void repack(File output) throws IOException {
        rezip(getUnpackDir(), output);
    }
}
