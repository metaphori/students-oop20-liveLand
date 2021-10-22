package view.gui;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;

public class DesignActivity {

    private static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    private static int width = (int) SCREEN.getWidth();
    private static int height = (int) SCREEN.getHeight();

    public static Square createShop(final int wh, final int ht, final int x, final int y, final String name, final int distance) {
        final Square shop = new Square();
        shop.setWidth(width / wh);
        shop.setHeight(height / ht);
        shop.setX(1);
        shop.setY(((width / y) + 1) + distance);
        shop.setColor(Color.YELLOW);
        shop.setName(name);
        return shop;
    }

    public static Square createRestaurant(final int wh, final int ht, final int x, final int y, final String name, final int distance) {
        final Square restaurant = new Square();
        restaurant.setWidth(height / ht);
        restaurant.setHeight(width / wh);
        restaurant.setX((width / x) + distance);
        restaurant.setY(height - (width / wh));
        restaurant.setColor(Color.GREEN);
        restaurant.setName(name);
        return restaurant;
    }

    public static Square createBabyFair(final int wh, final int ht, final int x, final int y, final String name, final int distance) {
        final Square babyFair = new Square();
        babyFair.setWidth(height / ht);
        babyFair.setHeight(width / wh);
        babyFair.setX((width / x) + distance);
        babyFair.setY(1);
        babyFair.setColor(Color.CYAN);
        babyFair.setName(name);
        return babyFair;
    }

    public static Square createAdultFair(final int wh, final int ht, final int x, final int y, final String name, final int distance) {
        final Square adultFair = new Square();
        adultFair.setWidth(height / ht);
        adultFair.setHeight(width / wh);
        adultFair.setX((width / x) + distance);
        adultFair.setY(1);
        adultFair.setColor(Color.RED);
        adultFair.setName(name);
        return adultFair;
    }

}
