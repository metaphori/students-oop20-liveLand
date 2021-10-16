package model;


public class PositionImpl implements Position{
	private Object coordinates;

	private final Pair<int, int> coordinates;

	public PositionImpl(final int x, final int y) {
		this.coordinates = new Pair<>(x, y);
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.coordinates.getFirst();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
