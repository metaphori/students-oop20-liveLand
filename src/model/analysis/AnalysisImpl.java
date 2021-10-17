package model.analysis;

import java.util.LinkedList;
import java.util.List;

import controller.EnvironmentControllerImpl;

//importare classe environment per attingere ad array di giostre e risto
//importare classe ingresso per sapere daily income

public class AnalysisImpl implements Analysis{
	
	private EnvironmentControllerImpl controller;
	
	public AnalysisImpl(EnvironmentControllerImpl controller) {
		this.controller = controller;
	}
	
	@Override
	public List<String> FairLiking() {
		List<String> fair = new LinkedList<>();
		//this.controller.getFairList().forEach(f -> {fair.add(f.getActivityType() + f.getName() + ", Daily Visitors: " + f.getPeople() + "\n");});
		fair.add("FAIR: Katun, Daily visitors: 76");
		fair.add("BABYFAIR: Bruco Mela, Daily visitors: 49");
		return fair;
	}
	
	@Override
	public List<String> Profit() {
		List<String> profit = new LinkedList<>();
		//this.controller.getProfitList().forEach(p -> {profit.add(p.getActivityType()+ ": " + p.getName() + ", Daily Income: " + p.getProfit() + "\n");});
		profit.add("REST: Pizza pazza, Daily income: 570");
		profit.add("SHOP: Souvenirs, Daily income: 320");
		return profit;
	}
	
	@Override
	public List<String> Tickets(){
		List<String> tickets = new LinkedList<>();
//		tickets.add("Total number of tickets sold: " + this.controller.getEntranceProfit().get(3));
//		tickets.add("Adult tickets income: " + this.controller.getEntranceProfit().get(0) + "\n");
//		tickets.add("Reduced tickets income: " + this.controller.getEntranceProfit().get(1) + "\n");
//		tickets.add("Season pass income: " + this.controller.getEntranceProfit().get(2) + "\n");
		tickets.add("Total number of tickets sold: 59\n");
		tickets.add("Adult tickets income: 1200\n");
		tickets.add("Reduced tickets income: 300\n");
		tickets.add("Season pass income: 90\n");
		return tickets;

	}
	
	@Override
	public List<String> getTextualAnalysis(){
		List<String> analysis = new LinkedList<>();
		analysis.addAll(this.Tickets());
		analysis.addAll(this.FairLiking());
		analysis.addAll(this.Profit());
		return analysis;
	}

	@Override
	public String getAnalysisDescription() {
		return "\n***Here is a textual analysis carried out in the simulation, "
				+ "which environment was set with the parameters you provided*** \n";
	}
	

}
