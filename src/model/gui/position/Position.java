package model.gui.position;

/**
 * 
 * @author enric
 *
 * @param <X>
 * @param <Y>
 */

public class Position<X, Y> {

    public Integer first;
    public Integer second;

    public Position(final Integer first, final Integer second) {
        this.first = first;
        this.second = second;
    }

    public final int getFirst() {
        return this.first;
    }

    public final int getSecond() {
        return this.second;
    }

    public final String toString() {
        return "<" + this.first + "," + this.second + ">";
    }
}
