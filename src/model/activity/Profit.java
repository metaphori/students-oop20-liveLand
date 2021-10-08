package model.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.person.ticket.PersonTicket;
import view.model.activity.ActivityType;

public class Profit implements Activity{

		private String name;
		private int money=0;
		private int totMoney=0;
		private int rideAttendance=0;
		private int totPeople=0;
		private int min;
		private int max;
		private ActivityType activityType;
		ArrayList<PersonTicket> person= new ArrayList<PersonTicket>();
		

		public Profit(String name, int min, int max, ActivityType activityType) {
			this.name = name;
			this.activityType = activityType;
			this.min=min;
			this.max=max;
			
		}

		@Override
		public int addPerson(List<PersonTicket> list) {
			rideAttendance=list.size();
			return rideAttendance;
			
		}

		
		public void profitRide (List<PersonTicket> list) {
			for(int count=0; count<=rideAttendance; count++) {
				money=amount(min, max);
				setProfit(getProfit()+money);	
			}
		}
		
		
		public void removePerson(List<PersonTicket> list) {
			list.clear();	
		}


		public int getAttendace(int rideAttendance) {
			totPeople=totPeople+rideAttendance;
			return totPeople;
		}


		public void setProfit(int money) {
			this.totMoney=money;
		}

		
		public int getProfit() {
			return totMoney;
		}
		
		
		public int amount(int min, int max) {
			Random r =  new Random();
			money=r.nextInt(((max-min)+1)+min);
			return money;
		}

		@Override
		public ActivityType getActivityType() {
			return this.activityType;
		}
		
		public String getName() {
			return this.name;
		}

		@Override
		public String toString() {
			return "Profit [name=" + name + ", money=" + money + ", totMoney=" + totMoney + ", rideAttendance="
					+ rideAttendance + ", totPeople=" + totPeople + ", min=" + min + ", max=" + max + ", activityType="
					+ activityType + ", person=" + person + "]";
		}
		
		


	}
