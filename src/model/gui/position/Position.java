package model.gui.position;

public class Position<X, Y> {

        public Integer first;
    public Integer second;
    
    public Position(Integer first, Integer second){
        this.first = first;
        this.second = second;
    }
    
    public int getFirst(){
        return this.first;
    }
    
    public int getSecond(){
        return this.second;
    }
    
    public String toString(){
        return "<"+this.first+","+this.second+">";
    }
}
