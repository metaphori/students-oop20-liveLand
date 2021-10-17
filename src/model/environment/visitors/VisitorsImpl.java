package model.environment.visitors;

import view.menu.VisitorsOutOfBoundException;

public class VisitorsImpl implements Visitors {

	private final int visitors;
	
	public VisitorsImpl(int visitors) {
		if(visitors >= 1 && visitors <= 100) {
			this.visitors = visitors;
		} else throw new VisitorsOutOfBoundException();	
	}
	
	@Override
	public int getVisitorsNumber() {
		return this.visitors;
	}

}
