package model.analysis;

	/**
	 * Interface showing questions the simulation must answer in the end
	 */
public interface Analysis {

	String mostLikedFair();
	
	String leastLikedFair();
	
	String mostProfitableRestaurant();
	
	int dailyIncome();
	
	//income per ogni attivtà presente (?) diversa da giostre
	
	//possibile istanziare attività e per ognuna chiamare metodo getIncome 

}
