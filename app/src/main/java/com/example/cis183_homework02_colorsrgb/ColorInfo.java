package com.example.cis183_homework02_colorsrgb;

import android.graphics.Color;

import java.io.Serializable;

public class ColorInfo implements Serializable {
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

    public String calculateHex() {
        String hex = "";
        int r = this.getRed();
        int g = this.getGreen();
        int b = this.getBlue();

        //forDigit() has radix set to 16 since hexadecimal is base-16
        //dividing color value by the new base (16) gives the tens position
        //it is how many 16s fit into the color value
        hex += Character.forDigit((r / 16), 16);
        //getting remainder of color value and new base (16) gives the ones position
        //it is what is left after seeing how many 16s fit into the color value
        hex += Character.forDigit((r % 16), 16);
        hex += Character.forDigit((g / 16), 16);
        hex += Character.forDigit((g % 16), 16);
        hex += Character.forDigit((b / 16), 16);
        hex += Character.forDigit((b % 16), 16);

        hex = hex.toUpperCase();

        return hex;
    }
}
