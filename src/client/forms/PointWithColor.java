package client.forms;

import common.data.Flat;

import java.awt.*;
import java.awt.geom.Point2D;

public class PointWithColor extends Point2D {
    public int x;
    public int y;
    public Color color;
    public int radius;
    public String text;
    private Flat flat;
    private int key;
    public PointWithColor(int x, int y, Color color, int radius, String text, Flat flat, int key) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radius = radius;
        this.text = text;
        this.flat = flat;
        this.key = key;
    }
    public Color getColor() {
        return color;
    }
    public String getText() {
        return text;
    }
    public Flat getFlat(){
        return flat;
    }
    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = (int) Math.floor(x + 0.5);
        this.y = (int) Math.floor(y + 0.5);
    }
}
