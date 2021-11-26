package org.mqjd.common;

public class BoundingRect {

    private int x;
    private int y;
    private int width;
    private int height;

    public BoundingRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public BoundingRect(Point point, Size size) {
        this.x = point.getX();
        this.y = point.getY();
        this.width = size.getWidth();
        this.height = size.getHeight();
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
