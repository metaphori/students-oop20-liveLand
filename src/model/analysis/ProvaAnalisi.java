package model.analysis;

import controller.EnvironmentControllerImpl;
import model.activity.Fair;
import model.activity.Profit;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityBuilder;
import view.model.activity.ViewActivityImpl;

public class ProvaAnalisi {
	
	private final EnvironmentControllerImpl envController = new EnvironmentControllerImpl();
//	private int visitors = 45;
//	private int money = 300;
//	private final ViewActivityImpl act1 = new ViewActivityBuilder("katun", ActivityType.FAIR).capacity(15).build();
//	private final ViewActivityImpl act2 = new ViewActivityBuilder("bruco mela", ActivityType.BABYFAIR).capacity(25).build();
//	private final ViewActivityImpl act3 = new ViewActivityBuilder("burger king", ActivityType.REST).minPrice(2).maxPrice(30).build();
//	private final ViewActivityImpl act4 = new ViewActivityBuilder("pizza pazza", ActivityType.REST).minPrice(10).maxPrice(25).build();
//	private final ViewActivityImpl act5 = new ViewActivityBuilder("souvenirs", ActivityType.SHOP).minPrice(1).maxPrice(15).build();
	
	public ProvaAnalisi(){
//		try {
//			this.envController.addNewActivity(act1);
//		} catch (ActivityAlreadyPresentException e) {
//			System.out.print(e.getMessage());
//		}
//		try {
//			this.envController.addNewActivity(act2);
//		} catch (ActivityAlreadyPresentException e) {
//			System.out.print(e.getMessage());
//		}
//		try {
//			this.envController.addNewActivity(act3);
//		} catch (ActivityAlreadyPresentException e) {
//			System.out.print(e.getMessage());
//		}
//		try {
//			this.envController.addNewActivity(act4);
//		} catch (ActivityAlreadyPresentException e) {
//			System.out.print(e.getMessage());
//		}
//		try {
//			this.envController.addNewActivity(act5);
//		} catch (ActivityAlreadyPresentException e) {
//			System.out.print(e.getMessage());
//		}
//		
//		for (Fair f: this.envController.getFairList()) {
//			f.setVisitors(this.visitors);
//			this.visitors -= 10;
//		}
//		
//		for (Profit p: this.envController.getProfitList()) {
//			p.setProfit(this.money);
//			this.money -= 55;
//		}
		
		this.envController.showAnalysis();
		
	}
	
    public static void main(final String[] args) {
    	new ProvaAnalisi();
    }
	

}
