package model.gui.activity;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import controller.EnvironmentControllerImpl;
import view.model.activity.ActivityType;
import view.model.activity.ViewActivityImpl;

public class ActivityInsertion {
    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = (int) SCREEN.getWidth();
    private static int height = (int) SCREEN.getHeight();
    private final List<Square> shop;
    private final List<Square> restaurant;
    private final List<Square> adultFair;
    private final List<Square> babyFair;
    private final EnvironmentControllerImpl controller;

    public ActivityInsertion(final EnvironmentControllerImpl controller) {
        this.shop = new LinkedList<>();
        this.restaurant = new LinkedList<>();
        this.adultFair = new LinkedList<>();
        this.babyFair = new LinkedList<>();
        this.controller = controller;
    }

    public void listActivity() {
        int distanceAdultFair = 0;
                //(this.width-(width/20)*this.controller.getFairList().size())/this.controller.getFairList().size();
        int distanceBabyFair = 0;
        int distanceShop = 0;
        int distanceRestaurant = 0;

        for (ViewActivityImpl a : this.controller.getActivityList()) {
            ActivityType type = a.getActivityType();
            switch (type) {
            case BABYFAIR: {
                babyFair.add(DesignActivity.createBabyFair(20, 9, 10, 10, a.getName(), distanceBabyFair));
                distanceBabyFair += 200;
            }
                break;
            case FAIR: {
                adultFair.add(DesignActivity.createAdultFair(20, 9, 2, 9, a.getName(), distanceAdultFair));
                distanceAdultFair += 200;
            }
                break;
            case SHOP: {
                shop.add(DesignActivity.createShop(20, 9, 0, 10, a.getName(), distanceShop));
                distanceShop += 200;
            }
                break;
            case REST: {
                restaurant.add(DesignActivity.createRestaurant(20, 9, 10, 10, a.getName(), distanceRestaurant));
                distanceRestaurant += 200;
            }
                break;

            }

        }

    }

    public List<Square> getShop() {
        return shop;
    }

    public List<Square> getRestaurant() {
        return restaurant;
    }

    public List<Square> getAdultFair() {
        return adultFair;
    }

    public List<Square> getBabyFair() {
        return babyFair;
    }

}




