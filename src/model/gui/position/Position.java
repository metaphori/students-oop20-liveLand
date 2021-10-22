package model.gui.position;

public class Position<X, Y> {

    public X first;
    public Y second;

    public Position(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return this.first;
    }

    public Y getSecond() {
        return this.second;
    }

    public String toString() {
        return "<" + this.first + "," + this.second + ">";
    }
}
