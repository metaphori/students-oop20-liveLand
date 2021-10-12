package view.model.activity;

import java.util.Optional;

public class ViewActivityImpl implements ViewActivity {
	
	private Optional<Integer> capacity;
	private Optional<Integer> minPrice;
	private Optional<Integer> maxPrice;
	private final String name;
	private final ActivityType activityType;
	
	//costruttore valido per giostre, sia per bambini che per adulti
	public ViewActivityImpl(String name, Optional<Integer> capacity, Optional<Integer> minPrice,
			Optional<Integer> maxPrice, ActivityType activityType){
		this.name = name;
		this.capacity = capacity;
		this.activityType = activityType;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	
//	//costruttore valido per shop e risto
//	public ViewActivityImpl(String name, int minPrice, int maxPrice, ActivityType activityType) {
//		this.name = name;
////		this.capacity = 0;
//		this.minPrice = minPrice;
//		this.maxPrice = maxPrice;
//		this.activityType = activityType;
//	}

	@Override
	public Optional<Integer> getCapacity() {
		return this.capacity;
	}

	@Override
	public Optional<Integer> getMinPrice() {
		return this.minPrice;
	}

	@Override
	public Optional<Integer> getMaxPrice() {
		return this.maxPrice;
	}

	@Override
	public ActivityType getActivityType() {
		return this.activityType;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "ViewActivityImpl [capacity=" + capacity + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", name=" + name + ", activityType=" + activityType + "]";
	}

}
