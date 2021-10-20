package person.environment.motion;

import java.util.Map;

import model.activity.Fair;
import model.activity.Profit;
import model.person.ticket.PersonTicket;

public class PeopleMovingIntoPark {
    
    private Map<PersonTicket, Position> people;
    //private Motion movementModel;
    
    public PeopleMovingIntoPark(Map<PersonTicket, Position> map) {
        this.people = map;
       // this.movementModel = new Motion(this.people);
    }
    
    public void goToFair(PersonTicket person, Fair fair) {
        //ricavare coordinate della giostra
        //this.movementModel.move(person, coordinate)
    }
    
    public void goToProfit(PersonTicket person, Profit profit) {
        //ricavare coordinate del profit
        //this.movementModel.move(person, coordinate)
    }

}
