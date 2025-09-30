    package com.example.cis183_homework02_colorsrgb;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        View main;
        TextView tv_j_red;
        SeekBar sb_j_red;
        TextView tv_j_green;
        SeekBar sb_j_green;
        TextView tv_j_blue;
        SeekBar sb_j_blue;
        TextView tv_j_hex;
        Button btn_j_save;
        ListView lv_j_colors;
        String[] test = {"Hello", "Hi", "Hola"};

        private boolean textColorChanged = false;
        private ColorInfo currentColor;
        private ArrayList<ColorInfo> listOfColors;
        ColorListAdapter clAdapter;

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

        main = findViewById(R.id.main);
        tv_j_red = findViewById(R.id.tv_v_red);
        sb_j_red = findViewById(R.id.sb_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        sb_j_green = findViewById(R.id.sb_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        btn_j_save = findViewById(R.id.btn_v_save);
        lv_j_colors = findViewById(R.id.lv_v_colors);

        currentColor = new ColorInfo(255, 255, 255);
        listOfColors = new ArrayList<>();

        addDummyDataToArrayList();
        printColors();
        fillListView();
        setListeners();
    }

        private void addDummyDataToArrayList() {
            ColorInfo newColor = new ColorInfo(69, 222, 18);
            listOfColors.add(newColor);
            newColor = new ColorInfo(171, 18, 222);
            listOfColors.add(newColor);
            newColor = new ColorInfo(18, 69, 222);
            listOfColors.add(newColor);
        }

        private void fillListView() {
            clAdapter = new ColorListAdapter(this, listOfColors);
            lv_j_colors.setAdapter(clAdapter);
        }

    private void setListeners() {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_red.setText("Red: " + progress);
                updateInfo(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_green.setText("Green: " + progress);
                updateInfo(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_blue.setText("Blue: " + progress);
                updateInfo(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn_j_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorInfo colorToAppend = new ColorInfo(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                listOfColors.add(colorToAppend);
                clAdapter.notifyDataSetChanged();
                resetInfo(255, 255, 255);
            }
        });
        //setOnItemClickListener instead of just setOnClickListener
        //so it tracks which specific object you click on
        lv_j_colors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //casts the selected object in the list view to ColorInfo
                ColorInfo selectedColor = (ColorInfo) parent.getItemAtPosition(position);
                main.setBackgroundColor(Color.rgb(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue()));
                resetInfo(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue());
            }
        });
    }

    private void updateInfo(int r, int g, int b) {
        currentColor.setRed(r);
        currentColor.setGreen(g);
        currentColor.setBlue(b);

        main.setBackgroundColor(Color.rgb(r, g, b));

        if((g < 120 && r < 130 && b < 180) && !textColorChanged) {
            tv_j_red.setTextColor(Color.WHITE);
            tv_j_green.setTextColor(Color.WHITE);
            tv_j_blue.setTextColor(Color.WHITE);
            tv_j_hex.setTextColor(Color.WHITE);
            textColorChanged = true;
        }
        else if((g > 120 || r > 130 || b > 180) && textColorChanged) {
            tv_j_red.setTextColor(Color.BLACK);
            tv_j_green.setTextColor(Color.BLACK);
            tv_j_blue.setTextColor(Color.BLACK);
            tv_j_hex.setTextColor(Color.BLACK);
            textColorChanged = false;
        }

        tv_j_hex.setText("Hex Representation: " + currentColor.calculateHex());
}

private void resetInfo(int r, int g, int b) {
    tv_j_red.setText("Red: " + r);
    tv_j_green.setText("Green: " + g);
    tv_j_blue.setText("Blue: " + b);
    sb_j_red.setProgress(r);
    sb_j_green.setProgress(g);
    sb_j_blue.setProgress(b);
    updateInfo(r, g, b);
}

    private void printColors() {
        for(int i = 0; i < listOfColors.size(); i++) {
            Log.d("Color " + i + ":", listOfColors.get(i).getRed() + ", " + listOfColors.get(i).getGreen() + ", " + listOfColors.get(i).getBlue() + ", " + listOfColors.get(i).calculateHex());
        }
    }
}