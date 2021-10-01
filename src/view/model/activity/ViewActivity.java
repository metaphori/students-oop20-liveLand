package view.model.activity;

public interface ViewActivity {
	//entità che possiede campi inseriti sulla base di ciò che viene selezionato dall'utente nel menu principale
	
	ActivityType getActivityType();
	
	int getCapacity();
	
	int getMinPrice();
	
	int getMaxPrice();
	
	//tipo di giostra?
	
}
