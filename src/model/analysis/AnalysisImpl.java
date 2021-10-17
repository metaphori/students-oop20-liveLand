package model.analysis;

import java.util.LinkedList;
import java.util.List;

import controller.EnvironmentControllerImpl;
import model.environment.activity.ActivityEnvironmentImpl;

//importare classe environment per attingere ad array di giostre e risto
//importare classe ingresso per sapere daily income

public class AnalysisImpl implements Analysis{
	
	private int participantsMostLikedFair;
	private int participantsLeastLikedFair;
	private int currentParticipants;
	private int restaurantIncome;
	private int incomeMostProfitableRestaurant;
	private String mostLikedFair;
	private String leastLikedFair;
	private String mostProfitableRestaurant;
	
	private EnvironmentControllerImpl controller;
	
	public void build() {
		this.participantsMostLikedFair = 0;
		this.participantsLeastLikedFair = 0;
		this.incomeMostProfitableRestaurant = 0;
	}
	
	public AnalysisImpl(EnvironmentControllerImpl controller) {
		this.controller = controller;
	}
	
	public List<String> FairLiking() {
		List<String> fair = new LinkedList<>();
		//this.controller.getFairList().forEach(f -> {fair.add(f.getActivityType() + f.getName() + ", Daily Visitors: " + f.getPeople() + "\n");});
		fair.add("FAIR: Katun, Daily visitors: 76");
		fair.add("BABYFAIR: Bruco Mela, Daily visitors: 49");
		return fair;
	}
	
	public List<String> Profit() {
		List<String> profit = new LinkedList<>();
		//this.controller.getProfitList().forEach(p -> {profit.add(p.getActivityType()+ ": " + p.getName() + ", Daily Income: " + p.getProfit() + "\n");});
		profit.add("REST: Pizza pazza, Daily income: 570");
		profit.add("SHOP: Souvenirs, Daily income: 320");
		return profit;
	}
	
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
	public String mostLikedFair() {
/*		for(int i=1; i<NumGiostre; i++) {
		this.currentParticipants = fair[i].getAttendance();
		if(this.currentParticipants > this.participantsMostLikedFair) {
			this.mostLikedFair = fair[i].getName();
		}
		} */
		
		return this.mostLikedFair; 
	}

	@Override
	public String leastLikedFair() {
/*		for(int i=1; i<NumGiostre; i++) {
		this.currentParticipants = fair[i].getAttendance();
		if(this.currentParticipants > this.participantsLeastLikedFair) {
			this.leastLikedFair = fair[i].getName();
		}
		} */
		return this.leastLikedFair; 
	}

	@Override
	public String mostProfitableRestaurant() {
/*		for(int i=1; i<NumRestaurants; i++) {
		this.restaurantIncome = restaurant[i].getIncome();
		if(this.restaurantIncome > this.incomeMostProfitableRestaurant) {
			this.mostProfitableRestaurant = fair[i].getName();
		}
		} */
		return this.mostProfitableRestaurant;
	}

	@Override
	public int dailyIncome() {
		//interrogare ingresso
		return 0;
	}
	
	public List<String> getTextualAnalysis(){
		List<String> analysis = new LinkedList<>();
		analysis.addAll(this.Tickets());
		analysis.addAll(this.FairLiking());
		analysis.addAll(this.Profit());
		return analysis;
	}
	

}
