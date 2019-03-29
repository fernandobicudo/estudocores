package com.fernando.estudo_cores;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int redValue = 255;
    private int greenValue = 255;
    private int blueValue = 255;

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    private TextView redValueTextView;
    private TextView greenValueTextView;
    private TextView blueValueTextView;

    private SurfaceView colorSurfaceView;

    private String redHex, greenHex, blueHex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redValueTextView = findViewById(R.id.redValueTextView);
        greenValueTextView = findViewById(R.id.greenValueTextView);
        blueValueTextView = findViewById(R.id.blueValueTextView);

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);

        redValueTextView.addTextChangedListener(textChangedWatcher);
        greenValueTextView.addTextChangedListener(textChangedWatcher);
        blueValueTextView.addTextChangedListener(textChangedWatcher);

        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        colorSurfaceView = findViewById(R.id.colorSurfaceView);

    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar SeekBar, int progress, boolean fromUser) {

            switch (SeekBar.getId()){

                case R.id.redSeekBar:
                    redValue = progress;
                    redValueTextView.setText(String.format("%d",redValue));
                    redHex = Integer.toHexString(redValue);


                    break;

                case R.id.greenSeekBar:
                    greenValue = progress;
                    greenValueTextView.setText(String.format("%d",greenValue));
                    break;

                case R.id.blueSeekBar:
                    blueValue = progress;
                    blueValueTextView.setText(String.format("%d",blueValue));
                    break;
            }
            colorSurfaceView.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private TextWatcher textChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
