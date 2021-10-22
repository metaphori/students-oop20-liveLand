package view.gui;

import java.awt.Color;

public class Square {
    private int width;
    private int height;
    private int x;
    private int y;
    private String name;
    private Color color;

    public Square() {
        this.width = 0;
        this.height = 0;
        this.x = 0;
        this.y = 0;
        this.name = null;
        this.color = Color.BLACK;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final int getWidth() {
        return width;
    }

    public final void setWidth(final int width) {
        this.width = width;
    }

    public final int getHeight() {
        return height;
    }

    public final void setHeight(final int height) {
        this.height = height;
    }

    public final Color getColor() {
        return color;
    }

    public final void setColor(final Color color) {
        this.color = color;
    }

    public final int getX() {
        return x;
    }

    public final void setX(final int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(final int y) {
        this.y = y;
    }

}
