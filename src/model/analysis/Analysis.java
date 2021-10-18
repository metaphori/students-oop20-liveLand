package model.analysis;

import java.util.List;

/**
	 * Interface showing questions the simulation must answer in the end
	 */
public interface Analysis {

	List<String> fairLiking();
	
	List<String> profit();
	
	List<String> tickets();
	
	List<String> getTextualAnalysis();
	
	String getAnalysisDescription();

}
