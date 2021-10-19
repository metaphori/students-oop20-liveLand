package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import model.analysis.Analysis;
import model.analysis.AnalysisImpl;
import model.analysis.PhonyAnalysisImpl;

public class FileControllerImpl implements FileController {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";

    private File dest = new File(HOME + SEPARATOR + DEFAULT_FILE);
    private final Analysis analysis;

    public FileControllerImpl(final EnvironmentControllerImpl controller) {
        this.analysis = new AnalysisImpl(controller);
    }

    public FileControllerImpl() {
        this.analysis = new PhonyAnalysisImpl();
    }

    public final void save() throws IOException {
        try (PrintStream out = new PrintStream(dest)) {
            out.println("FUNFAIR SIMULATOR ANALYSIS");
            out.println(analysis.getAnalysisDescription());
            analysis.getTextualAnalysis().forEach(s -> {
                out.print(s); });
        }
    }

    public final void setDestination(final File file) {
        final File parent = file.getParentFile();
        if (parent.exists()) {
            dest = file;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }
}
