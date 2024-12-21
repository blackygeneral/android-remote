package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textCounter;
    private int counter = 0;
    private boolean isCountingEnabled = true; // Flag to enable or disable counting
    private String[] modes = {"Cool", "Dry", "Hot"}; // Modes array
    private int currentModeIndex = 0; // Tracks the current mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to views
        textCounter = findViewById(R.id.text_counter);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonOn = findViewById(R.id.button_on);
        Button buttonOff = findViewById(R.id.button_off);
        Button buttonMode = findViewById(R.id.button_mode);

        // Set up button click listeners
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCountingEnabled) { // Check if counting is enabled
                    counter--;
                    textCounter.setText(String.valueOf(counter));
                }
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCountingEnabled) { // Check if counting is enabled
                    counter++;
                    textCounter.setText(String.valueOf(counter));
                }
            }
        });

        buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCountingEnabled = true; // Enable counting
                textCounter.setText("ON"); // Display "ON" in the TextView
                Toast.makeText(MainActivity.this, "Counting Enabled", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCountingEnabled = false; // Disable counting
                textCounter.setText("OFF"); // Display "OFF" in the TextView
                Toast.makeText(MainActivity.this, "Counting Disabled", Toast.LENGTH_SHORT).show();
            }
        });

        buttonMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cycle through modes
                currentModeIndex = (currentModeIndex + 1) % modes.length; // Update mode index
                textCounter.setText(modes[currentModeIndex]); // Display current mode
                Toast.makeText(MainActivity.this, "Mode: " + modes[currentModeIndex], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
