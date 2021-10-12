package model.environment.visitors;

public class VisitorsImpl implements Visitors {

	private final int visitors;
	
	public VisitorsImpl(int visitors) {
		this.visitors = visitors;
	}
	
	@Override
	public int getVisitorsNumber() {
		return this.visitors;
	}

}
