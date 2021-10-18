package model.analysis;

import java.util.List;

/**
	 * Interface showing questions the simulation must answer in the end
	 */
public interface Analysis {

	List<String> FairLiking();
	
	List<String> Profit();
	
	List<String> Tickets();
	
	List<String> getTextualAnalysis();
	
	String getAnalysisDescription();

}
