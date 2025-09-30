    package com.example.cis183_homework02_colorsrgb;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

    private ArrayList<ColorInfo> listOfColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listOfColors = new ArrayList<>();

        addDummyDataToArrayList();
        printColors();
    }

    private void addDummyDataToArrayList() {
        ColorInfo newColor = new ColorInfo(69, 222, 18);
        listOfColors.add(newColor);
        newColor = new ColorInfo(171, 18, 222);
        listOfColors.add(newColor);
        newColor = new ColorInfo(18, 69, 222);
        listOfColors.add(newColor);
    }

    private void printColors() {
        for(int i = 0; i < listOfColors.size(); i++) {
            Log.d("Color " + i + ":", listOfColors.get(i).getRed() + ", " + listOfColors.get(i).getGreen() + ", " + listOfColors.get(i).getBlue() + ", " + convertToHex(listOfColors.get(i)));
        }
    }

    private String convertToHex(ColorInfo color) {
        String hex = "#";
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

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

        return hex;
    }
}