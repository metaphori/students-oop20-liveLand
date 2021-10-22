package person.environment.motion;

import java.util.Map;

import model.activity.Fair;
import model.activity.Profit;
import model.gui.position.Position;
import model.person.ticket.PersonTicket;

public class PeopleMovingIntoPark {
    
    private Map<PersonTicket, Position<Integer, Integer>> people;
    //private Motion movementModel;
    
    public PeopleMovingIntoPark(Map<PersonTicket, Position<Integer, Integer>> map) {
        this.people = map;
       // this.movementModel = new Motion(this.people);
    }
    
    public void goToFair(PersonTicket person, Fair fair) {
        System.out.println("persona: " + person.toString() + "va in giostra: " + fair.getName());
        //ricavare coordinate della giostra
        //while non mi ritorna posizione della giostra, continuo a far generare coord sempre piu vicine
        //this.people.replace(person, this.movementModel.move(this.people.get(person), coordinate))
    }
    
    public void goToProfit(PersonTicket person, Profit profit) {
        System.out.println("persona: " + person.toString() + "va in profit: " + profit.getName());
        //ricavare coordinate del profit
      //this.people.replace(person, this.movementModel.move(this.people.get(person), coordinate))
    }

}
