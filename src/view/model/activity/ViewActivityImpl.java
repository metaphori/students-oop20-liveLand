package view.model.activity;

public class ViewActivityImpl implements ViewActivity {
	
	private int capacity = 0;
	private int minPrice = 0;
	private int maxPrice = 0;
	private final String name;
	private final ActivityType activityType;
	
	//costruttore valido per giostre, sia per bambini che per adulti
	public ViewActivityImpl(String name, int capacity, ActivityType activityType) {
		this.name = name;
		this.capacity = capacity;
		this.activityType = activityType;
	}
	
	//costruttore valido per shop e risto
	public ViewActivityImpl(String name, int minPrice, int maxPrice, ActivityType activityType) {
		this.name = name;
//		this.capacity = 0;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.activityType = activityType;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public int getMinPrice() {
		return this.minPrice;
	}

	@Override
	public int getMaxPrice() {
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
