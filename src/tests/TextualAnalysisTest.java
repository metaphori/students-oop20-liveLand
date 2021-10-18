package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.junit.Test;

import controller.EnvironmentControllerImpl;
import controller.FileControllerImpl;
import model.analysis.PhonyAnalysisImpl;

public class TextualAnalysisTest {
	
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String DEFAULT_FILE = "output.txt";
    private static final int ACTIVITY_SIZE = 2;
    private static final int TICKET_SIZE = 4;
	
	private PhonyAnalysisImpl analysis = new PhonyAnalysisImpl();
	private FileControllerImpl controller = new FileControllerImpl();
	
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
	
	@Test
	public void testAnalysisSaving() {
		try {
			this.controller.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader reader = new BufferedReader(new FileReader(HOME + SEPARATOR + DEFAULT_FILE));
			assertEquals(reader.readLine(), "FUNFAIR SIMULATOR ANALYSIS");
			reader.readLine();
			assertEquals(reader.readLine(), this.analysis.getAnalysisDescription().replace("\n", ""));
			reader.readLine();
			for(int i=0; i<TICKET_SIZE; i++) {
				assertEquals(reader.readLine(), this.analysis.getTextualAnalysis().get(i).replace("\n", ""));
			}
			for(int i=0; i<ACTIVITY_SIZE; i++) {
				assertEquals(reader.readLine(), this.analysis.FairLiking().get(i).replace("\n", ""));
			}
			for(int i=0; i<ACTIVITY_SIZE; i++) {
				assertEquals(reader.readLine(), this.analysis.Profit().get(i).replace("\n", ""));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
