package view.model.activity;

import java.util.Optional;

public interface ViewActivity {
	//entità che possiede campi inseriti sulla base di ciò che viene selezionato dall'utente nel menu principale
	
	ActivityType getActivityType();
	
	Optional<Integer> getCapacity();
	
	Optional<Integer> getMinPrice();
	
	Optional<Integer> getMaxPrice();
	
	String getName();
	
	//tipo di giostra?
	
}
