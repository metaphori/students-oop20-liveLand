package model.person.entrance;


import model.person.ticket.PersonTicket;


public class EntranceImpl implements Entrance{

	private int profit;
	private int numTickets;
	private int adultProfit=0;
	private int reducedProfit=0;
	private int passProfit=0;
	
	
	public  void addPerson( PersonTicket personTicket) {
		switch(personTicket.getTicket()) {
			case ADULT:
				adultProfit += personTicket.getTicket().getPrice();
				break;
			case REDUCED:
				reducedProfit += personTicket.getTicket().getPrice();
				break;
			case SEASON_PASS:
				passProfit += personTicket.getTicket().getPrice();
				
		}
		profit =+ personTicket.getTicket().getPrice();
		numTickets++;
	}
	
	public int getProfit() {
		return profit;
	}
	
	public int getNumTickets() {
		return numTickets;
	}
	
	public int getAdultProfit() {
		return adultProfit;
	}
	
	public int getReducedProfit() {
		return reducedProfit;
	}
	
	public int getPassProfit() {
		return passProfit;
	}
}
