package model.gui.activity;

import java.util.List;

public class ActivityInsertion {
	private List<Square> shop;
	private List<Square> restaurant;
	private List<Square> adultFair;
	private List<Square> babyFair;

	public ActivityInsertion() {
		this.shop = shop;
		this.restaurant = restaurant;
		this.adultFair = adultFair;
		this.babyFair = babyFair;
	}

	public void listActivity() {
		int distanceAdultFair=0;
		int distanceBabyFair=0;
		int distanceShop=0;
		int distanceRestaurant=0;
		
		 for(ViewActivityImpl a: controller.getActivList()) {
			 ActivityType type =  a.getType();
			 swich(type){ 
				 case BABYFAIR: {
					 babyFair.add(StaticFactoryBuilding.createBabyFair(20, 9, 10, 10, "bruco", distanceBabyFair));
					 distanceBabyFair= +200;
				 }
				 break; 
				 case ADULTFAIR: {
					 adultFair.add(StaticFactoryBuilding.createAdultFair(20, 9, 2, 9, "katun", distanceAdultFair));
					 distanceAdultFair = +200;
				 }
				 break; 
				 case SHOP: {
					 shop.add(StaticFactoryBuilding.createShop(20, 9, 0, 10, "Gingilli", distanceShop));
					 distanceShop = +200;
				 } 
				 break; 
				 case RESTAURANT: {
					 restaurant.add(StaticFactoryBuilding.createRestaurant(20, 9, 10, 10, "pizza",distanceRestaurant));
					 distanceRestaurant = +200;
				 }				 
				 break; 
		 
		  }
	
	}
}




