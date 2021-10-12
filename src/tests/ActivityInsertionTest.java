package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controller.EnvironmentControllerImpl;
import view.model.activity.ActivityAlreadyPresentException;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ActivityInsertionTest {
	
	private EnvironmentControllerImpl controller = new EnvironmentControllerImpl();
	private final ViewActivityImpl act1 = new ViewActivityImpl("katun", 15, ActivityType.FAIR);
	private final ViewActivityImpl act2 = new ViewActivityImpl("bruco mela", 30, ActivityType.BABYFAIR);
	private final ViewActivityImpl act3 = new ViewActivityImpl("burger king", 2, 30, ActivityType.REST);
	private final ViewActivityImpl act4 = new ViewActivityImpl("pizza pazza", 10, 25, ActivityType.REST);
	private final ViewActivityImpl act5 = new ViewActivityImpl("souvenirs", 1, 15, ActivityType.SHOP);
	
	@Test
	public void testActivityCreation() {
		assertNotEquals("Activities 1 and 2 are not equal", this.act1, this.act2);
		assertNotEquals("Activities 3 and 5 are not equal", this.act3, this.act5);
		assertEquals("Activities 3 and 4 have the same activity type", this.act3.getActivityType(),
				this.act4.getActivityType());
	}
	
	@Test
	public void testActivityInsertion() {
		try {
			this.controller.addNewActivity(this.act1);
		}catch(ActivityAlreadyPresentException exc) {
			System.out.print(exc.getMessage());
		}
		assertTrue("Activity1 correctly added in controller's list", 
				this.controller.modelActivity.getActivityList().contains(this.act1));
		try {
			this.controller.addNewActivity(this.act3);
		}catch(ActivityAlreadyPresentException exc) {
			System.out.print(exc.getMessage());
		}
		assertTrue("Activity3 correctly added in controller's list", 
				this.controller.modelActivity.getActivityList().contains(act3));
		assertThrows(ActivityAlreadyPresentException.class, () -> this.controller.addNewActivity(act3));
		assertFalse("Activity3 not added, already present!", this.controller.modelActivity.getActivityList().size() == 3);
	}

	@Test
	public void testReset() {
		this.controller.resetActivityList();
		assertTrue("Activity list correctly emptied", this.controller.modelActivity.getActivityList().isEmpty());
	}
}
