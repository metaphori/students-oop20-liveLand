package controller;

import java.io.IOException;

public interface Controller {
	
	void setView();
	
	/**
	 * @param path to the file in which the analysis should be saved
	 * @throws IOException
	 */
	void saveAnalysis(String path) throws IOException;
	

}
