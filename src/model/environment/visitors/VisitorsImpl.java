package model.environment.visitors;

import view.menu.VisitorsOutOfBoundException;

public class VisitorsImpl implements Visitors {

    private final int visitors;

    public VisitorsImpl(final int visitors) {
        if (visitors >= 1 && visitors <= 100) {
            this.visitors = visitors;
        } else {
            throw new VisitorsOutOfBoundException();
        }
    }

    @Override
    public final int getVisitorsNumber() {
        return this.visitors;
    }

}
