package model.gui.person;

import java.awt.Color;

public class DesignPerson {
	
	public static PersonGuiImpl createAdult(){
		PersonGuiImpl adult = new PersonGuiImpl();
		adult.setColor(Color.GREEN);
		adult.setRadius();
		adult.setPosition();
		return adult;
	}

	public static PersonGuiImpl createBaby() {
		PersonGuiImpl baby = new PersonGuiImpl();
		baby.setColor(Color.PINK);
		baby.setRadius();
		baby.setPosition();
		return baby;
	}
	
}
