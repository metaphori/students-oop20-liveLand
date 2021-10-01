package model.analysis;

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
	
	public void build() {
		this.participantsMostLikedFair = 0;
		this.participantsLeastLikedFair = 0;
		this.incomeMostProfitableRestaurant = 0;
	}
	

	@Override
	public String mostLikedFair() {
		for(int i=1; i<NumGiostre; i++) {
		this.currentParticipants = fair[i].getAttendance();
		if(this.currentParticipants > this.participantsMostLikedFair) {
			this.mostLikedFair = fair[i].getName();
		}
		}
		return this.mostLikedFair;
	}

	@Override
	public String leastLikedFair() {
		for(int i=1; i<NumGiostre; i++) {
		this.currentParticipants = fair[i].getAttendance();
		if(this.currentParticipants > this.participantsLeastLikedFair) {
			this.leastLikedFair = fair[i].getName();
		}
		}
		return this.leastLikedFair;
	}

	@Override
	public String mostProfitableRestaurant() {
		for(int i=1; i<NumRestaurants; i++) {
		this.restaurantIncome = restaurant[i].getIncome();
		if(this.restaurantIncome > this.incomeMostProfitableRestaurant) {
			this.mostProfitableRestaurant = fair[i].getName();
		}
		}
		return this.mostProfitableRestaurant;
	}

	@Override
	public int dailyIncome() {
		//interrogare ingresso
		return 0;
	}
	

}
