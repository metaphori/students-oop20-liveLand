package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.analysis.PhonyAnalysisImpl;

public class TextualAnalysisTest {
	
	private PhonyAnalysisImpl analysis = new PhonyAnalysisImpl();
	
	@Test
	public void testAnalysisCreation() {
		assertNotNull("Fair liking textual analysis correcly created", 
				this.analysis.FairLiking());
		assertNotNull("Profit textual analysis correcly created", 
				this.analysis.Profit());
		assertNotEquals("Fair liking and profit textual analysis are not equal", 
				this.analysis.FairLiking(), this.analysis.Profit());
		assertEquals("Fair items are exactly 6", this.analysis.FairLiking().size(), 6);
		assertNotNull("Tickets sold textual analysis correcly created",
				this.analysis.Tickets());
		assertNotNull("Textual analysis correcly created",
				this.analysis.getTextualAnalysis());
		assertEquals("Textual analysis strings are exactly 30",
				this.analysis.getTextualAnalysis().size(), 30);
	}

}
