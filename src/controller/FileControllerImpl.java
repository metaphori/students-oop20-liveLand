package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import model.analysis.AnalysisImpl;
import view.analysis.AnalysisBuilder;

/**
 *
 */
public class FileControllerImpl {

    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";

    private File dest = new File(HOME + SEPARATOR + DEFAULT_FILE);
    private EnvironmentControllerImpl controller;

    public FileControllerImpl(EnvironmentControllerImpl controller) {
    	this.controller = controller;
    }
    /**
     * Saves a given text on the chosen file.
     * 
     * @param text
     *            the text to save
     * @throws IOException
     *             if the writing fails
     */
    public void save() throws IOException {
        List<String> analysis = new AnalysisImpl(controller).getTextualAnalysis();
    	try (PrintStream out = new PrintStream(dest)) {
            //out.println(new AnalysisBuilder(controller).getAnalysisDescription());
            out.println("FUNFAIR SIMULATOR ANALYSIS");
        	out.println(this.getAnalysisDescription());
        	analysis.forEach(s -> {out.print(s);});
        }
    	
    }
    
	public String getAnalysisDescription() {
		return "\n***Here is a textual analysis carried out in the simulation, "
				+ "which environment was set with the parameters you provided*** \n";
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