package view.menu;

import controller.EnvironmentControllerImpl;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityBuilder;
import view.model.activity.ViewActivityImpl;

public class DefaultSetting {
	
	private final ViewActivityImpl act1 = new ViewActivityBuilder("Katun", ActivityType.FAIR).capacity(15).build();
	private final ViewActivityImpl act2 = new ViewActivityBuilder("Bruco Mela", ActivityType.BABYFAIR).capacity(25).build();
	private final ViewActivityImpl act3 = new ViewActivityBuilder("Raptor", ActivityType.FAIR).capacity(20).build();
	private final ViewActivityImpl act4 = new ViewActivityBuilder("Burger King", ActivityType.REST).minPrice(7).maxPrice(30).build();
	private final ViewActivityImpl act8 = new ViewActivityBuilder("Mc", ActivityType.REST).minPrice(7).maxPrice(30).build();
	private final ViewActivityImpl act5 = new ViewActivityBuilder("Pizza Pazza", ActivityType.REST).minPrice(10).maxPrice(25).build();
	private final ViewActivityImpl act6 = new ViewActivityBuilder("Gingilli", ActivityType.SHOP).minPrice(1).maxPrice(20).build();
	private final ViewActivityImpl act7 = new ViewActivityBuilder("Souvenirs", ActivityType.SHOP).minPrice(5).maxPrice(15).build();
	
	
	public DefaultSetting(EnvironmentControllerImpl view, GraphicalUserInterface gui) {
		try {
		view.addNewActivity(act1);
		view.addNewActivity(act2);
		view.addNewActivity(act3);
		view.addNewActivity(act4);
		view.addNewActivity(act5);
		view.addNewActivity(act6);
		view.addNewActivity(act7);
		view.addNewActivity(act8);
		gui.menuPanel.setActList(act1);
		gui.menuPanel.setActList(act2);
		gui.menuPanel.setActList(act3);
		gui.menuPanel.setActList(act4);
		gui.menuPanel.setActList(act5);
		gui.menuPanel.setActList(act6);
		gui.menuPanel.setActList(act7);
		gui.menuPanel.setActList(act8);
		}catch (ActivityAlreadyPresentException exc) {
			System.out.print(exc.getMessage());
		}
		
		
	}

}
