package com.example.cis183_homework02_colorsrgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter {
    Context context;
    ArrayList<ColorInfo> listOfColors;

    public ColorListAdapter(Context c, ArrayList<ColorInfo> lc) {
        context = c;
        listOfColors = lc;
    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.color_cell, null);
        }

        //finds GUI elements in custom cell
        TextView red = convertView.findViewById(R.id.tv_v_cell_red);
        TextView green = convertView.findViewById(R.id.tv_v_cell_green);
        TextView blue = convertView.findViewById(R.id.tv_v_cell_blue);
        TextView hex = convertView.findViewById(R.id.tv_v_cell_hex);

        ColorInfo color = listOfColors.get(position);
        red.setText("Red: " + color.getRed());
        green.setText("Green: " + color.getGreen());
        blue.setText("Blue: " + color.getBlue());
        hex.setText("Hex: " + color.calculateHex());
        if((color.getRed() < 120 && color.getGreen() < 130 && color.getBlue() < 180)) {
            red.setTextColor(Color.WHITE);
            green.setTextColor(Color.WHITE);
            blue.setTextColor(Color.WHITE);
            hex.setTextColor(Color.WHITE);
        }

        convertView.setBackgroundColor(Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));

        return convertView;
    }
}