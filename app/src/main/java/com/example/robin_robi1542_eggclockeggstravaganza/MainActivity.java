package com.example.robin_robi1542_eggclockeggstravaganza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Clock> clocks = new ArrayList<>();
    private ClockAdapter clockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView and Adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        clockAdapter = new ClockAdapter(clocks);
        recyclerView.setAdapter(clockAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Example: Add three initial clocks
        addClock();
        addClock();
        addClock();
    }

    private void addClock() {
        // Inflate the layout for a single clock
        View clockView = LayoutInflater.from(this).inflate(R.layout.clock_item, null);
        EditText editTextMinutes = clockView.findViewById(R.id.editTextMinutes);
        EditText editTextSeconds = clockView.findViewById(R.id.editTextSeconds);
        Button btnStartStop = clockView.findViewById(R.id.btnStartStop);

        // Create a new Clock instance and add it to the list
        Clock newClock = new Clock(clockView, editTextMinutes, editTextSeconds, btnStartStop);
        clocks.add(newClock);

        // Notify the adapter that the data set has changed
        clockAdapter.notifyDataSetChanged();
    }

    // You can add methods to remove clocks, handle actions, etc.
}
