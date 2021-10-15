package model.activity;

import java.util.ArrayList;
import java.util.Random;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public class Profit implements Activity{

		private String name;
		private int money=0;
		private int totMoney=0;
		private int totPeople=0;
		private int min;
		private int max;
		private ActivityType activityType;
		ArrayList<PersonTicket> personList= new ArrayList<PersonTicket>();
		

		public Profit(String name, int min, int max, ActivityType activityType) {
			this.name = name;
			this.activityType = activityType;
			this.min=min;
			this.max=max;
		}
		
		
		public Profit(String name, int min, int max, ActivityType activityType, int visitors) {
			this.name = name;
			this.activityType = activityType;
			this.min=min;
			this.max=max;
			this.totPeople=visitors;
		}

		
		public void addPerson(PersonTicket person) {
			personList.add(person);
			amount();	
			totPeople++;
		}

		
		public ArrayList<PersonTicket> getPeople() {
			return personList;
		}
		
		
		public void removePerson() {
			personList.clear();
		}


		public void setProfit(int money) {
			this.totMoney=money;
		}

		
		public int getProfit() {
			return totMoney;
		}
		
		
		public int getTotPeople() {
			return totPeople;
		}
		
		
		public void amount() {
			Random r =  new Random();
			money=r.nextInt(((max-min)+1)+min);
			setProfit(getProfit()+money);
			
		}

		
		public ActivityType getActivityType() {
			return this.activityType;
		}
		
		public String getName() {
			return this.name;
		}

		
		public ArrayList<PersonTicket> getPeopleList() {
			return personList;
			
		}
		
}
	
		
		
