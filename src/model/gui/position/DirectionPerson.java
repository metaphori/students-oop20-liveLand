package model.gui.position;

import java.awt.Point;
import java.time.Duration;

import model.gui.person.CircleImpl;
import view.gui.SimulationPanel;

public class DirectionPerson extends CircleImpl{
     
    public DirectionPerson(int x, int y){
        
    Point aPoint = new Point();
    Point bPoint = new Point(50, 25);
    Point cPoint = new Point(bPoint);
    
    System.out.println("cPoint is located at: " + cPoint);
    
    System.out.println("aPoint is located at: " + aPoint);
    aPoint.move(100, 50);

    bPoint.x = 110;
    bPoint.y = 70;

    aPoint.translate(10, 20);
    System.out.println("aPoint is now at: " + aPoint);

    if (aPoint.equals(bPoint))
      System.out.println("aPoint and bPoint are at the same location.");
  }
        
     
}
