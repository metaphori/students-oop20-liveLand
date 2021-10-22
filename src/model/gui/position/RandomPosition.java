package model.gui.position;

import java.util.Map;
import java.util.Random;

import model.person.ticket.PersonTicket;

public class RandomPosition {
    
    private int randX;
    private int randY;
    private Position<Integer, Integer> newPos;
   
    public Position<Integer, Integer> randomPosition(Map<PersonTicket, Position<Integer, Integer>> map) {
        final Random rand = new Random();
        do {
            randX = rand.nextInt(150);
            randY = rand.nextInt(100);
            this.newPos = new Position<>(this.randX, this.randY);
        } while(map.containsValue(this.newPos));
        return this.newPos;
    }

}
