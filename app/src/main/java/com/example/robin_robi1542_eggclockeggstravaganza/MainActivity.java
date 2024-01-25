package com.example.robin_robi1542_eggclockeggstravaganza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;


public class MainActivity extends AppCompatActivity {

    GridLayout gridLayout = findViewById(R.id.gridLayout);
    View clock1 = findViewById(R.id.activityClock1);
    View clock2 = findViewById(R.id.activityClock2);
    View clock3 = findViewById(R.id.activityClock3);
    View clock4 = findViewById(R.id.activityClock4);
    View clock5 = findViewById(R.id.activityClock5);
    View clock6 = findViewById(R.id.activityClock6);
    View clock7 = findViewById(R.id.activityClock7);
    View clock8 = findViewById(R.id.activityClock8);
    View clock9 = findViewById(R.id.activityClock9);

    EditText timer1 = findViewById(R.id.editTextTimer);

    Button btnStartStop1 = findViewById(R.id.btnStartStop);
    Button btnDelete1 = findViewById(R.id.btnDelete);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set input filters for EditText
        setInputFilters(timer1);
    }

    private void setInputFilters(EditText editText) {
        editText.setFilters(new InputFilter[]{
                new InputFilterMinMax("0", "300") // Set the range for minutes. Vi gider ikke mere end fem timer!
        });
    }
}




class InputFilterMinMax implements InputFilter {

    private int min, max;

    public InputFilterMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
            // Do nothing for now
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
