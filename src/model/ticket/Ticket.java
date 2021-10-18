package model.ticket;

/* ENUM of all the types of tickets that a person can choose,
 * it's composed by NAME and PRICE*/

public enum Ticket {
	ADULT(30),
	REDUCED(20),
	SEASON_PASS(50);
	
	
	private final Integer price;

/*Constructor of the class ticket*/
	private Ticket(final Integer price){
		this.price = price;
		}

/*Method that returns the price of the ticket*/
	public Integer getPrice() {
		return price;
	}
	
}
