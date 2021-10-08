package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import view.analysis.AnalysisBuilder;

/**
 *
 */
public class FileControllerImpl {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";

    private File dest = new File(HOME + SEPARATOR + DEFAULT_FILE);

    /**
     * Saves a given text on the chosen file.
     * 
     * @param text
     *            the text to save
     * @throws IOException
     *             if the writing fails
     */
    public void save(AnalysisControllerImpl controller) throws IOException {
        try (PrintStream out = new PrintStream(dest)) {
            out.println(new AnalysisBuilder(controller));
        }
    }

    /**
     * @param file
     *            the file where to write
     */
    public void setDestination(final File file) {
        final File parent = file.getParentFile();
        if (parent.exists()) {
            dest = file;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }
}