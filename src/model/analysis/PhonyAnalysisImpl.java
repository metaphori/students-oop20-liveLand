package model.analysis;

import java.util.LinkedList;
import java.util.List;

public class PhonyAnalysisImpl implements Analysis {
	
	//necessario ai fini di testing e debugging
	
	private final List<String> fair = new LinkedList<>();
	private final List<String> profit = new LinkedList<>();
	private final List<String> tickets = new LinkedList<>();

	@Override
	public List<String> fairLiking() {
		this.fair.add("FAIR: Katun, Daily visitors: 76\n");
		this.fair.add("BABYFAIR: Bruco Mela, Daily visitors: 49\n");
		return this.fair;
	}

	@Override
	public List<String> profit() {
		this.profit.add("REST: Pizza pazza, Daily income: 570\n");
		this.profit.add("SHOP: Souvenirs, Daily income: 320\n");
		return this.profit;
	}

	@Override
	public List<String> tickets() {
		this.tickets.add("Total number of tickets sold: 59\n");
		this.tickets.add("Adult tickets income: 1200\n");
		this.tickets.add("Reduced tickets income: 300\n");
		this.tickets.add("Season pass income: 90\n");
		return this.tickets;
	}

	@Override
	public List<String> getTextualAnalysis() {
		final List<String> analysis = new LinkedList<>();
		analysis.addAll(this.tickets());
		analysis.addAll(this.fairLiking());
		analysis.addAll(this.profit());
		return analysis;
	}

	@Override
	public String getAnalysisDescription() {
		return "\n***Here is a textual analysis carried out in the simulation, "
				+ "which environment was set with the parameters you provided*** \n";
	}

}
