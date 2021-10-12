package view.model.activity;

import java.util.Optional;

public class ViewActivityBuilder {
	private Optional<Integer> capacity = Optional.empty();
	private Optional<Integer> minPrice = Optional.empty();
	private Optional<Integer> maxPrice = Optional.empty();
	private final String name;
	private final ActivityType activityType;
	
	public ViewActivityBuilder(String name, ActivityType actType) {
		this.name = name;
		this.activityType = actType;
	}
	
	public ViewActivityBuilder capacity(int capacity) {
		this.capacity = Optional.ofNullable(capacity);
		return this;
	}
	
	public ViewActivityBuilder minPrice(int minPrice) {
		this.minPrice = Optional.ofNullable(minPrice);
		return this;
	}
	
	public ViewActivityBuilder maxPrice(int maxPrice) {
		this.maxPrice = Optional.ofNullable(maxPrice);
		return this;
	}
	
	public ViewActivityImpl build() {
		return new ViewActivityImpl(this.name, this.capacity, this.minPrice,
				this.maxPrice, this.activityType);
	}

}
