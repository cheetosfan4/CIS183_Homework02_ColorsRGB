package com.example.cis183_homework02_colorsrgb;

public class ColorInfo {
    private int red;
    private int green;
    private int blue;

    //default constructor
    public ColorInfo() {

    }
    //overloaded constructor
    public ColorInfo(int r, int g, int b) {
        red = r;
        green = g;
        blue = b;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
