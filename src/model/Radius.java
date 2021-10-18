package model;


public class Radius {
	
	private final Pair<Integer, Integer> coordinates;
	
	public Radius(final int x, final int y) {
		this.coordinates = Pair.of(x, y);
	}
	
	public int getRadiusX() {
		return this.coordinates.getFirst();
	}
	
	public int getRadiusY() {
		return this.coordinates.getSecond();
	}

}
