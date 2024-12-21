package com.example.myapplication;



import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputLength, inputWidth;
    private TextView textArea, textPerimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        inputLength = findViewById(R.id.input_length);
        inputWidth = findViewById(R.id.input_width);
        Button buttonCalculate = findViewById(R.id.button_calculate);
        textArea = findViewById(R.id.text_area);
        textPerimeter = findViewById(R.id.text_perimeter);

        // Set up the Calculate button click listener
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRectangle();
            }
        });
    }

    private void calculateRectangle() {
        // Get user input
        String lengthInput = inputLength.getText().toString();
        String widthInput = inputWidth.getText().toString();

        // Check for empty input
        if (TextUtils.isEmpty(lengthInput) || TextUtils.isEmpty(widthInput)) {
            Toast.makeText(this, "Please enter both length and width", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse input values
        double length = Double.parseDouble(lengthInput);
        double width = Double.parseDouble(widthInput);

        // Calculate area and perimeter
        double area = length * width;
        double perimeter = 2 * (length + width);

        // Update UI with results
        textArea.setText("Area: " + area);
        textPerimeter.setText("Perimeter: " + perimeter);
    }
}
