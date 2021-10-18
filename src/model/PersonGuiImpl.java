package model;

import java.util.Random;

import model.Pair;
import model.Radius;
import view.gui.CreatePersonGui;

public class PersonGuiImpl extends CreatePersonGui implements PersonGui{

	private static final Random RND = new Random();
	public double x, y;
	private double radius;
	
	public void getPosition() {
		int x = RND.nextInt();
		int y = RND.nextInt();
	}
	
	public void getRadius() {
		Double area = Math.PI * radius * radius;    
	}

	public void getColor() {
		
		
	}
	

	
}
