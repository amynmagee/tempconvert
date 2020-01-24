package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private EditText fahBox;
    private EditText celBox;
    private RadioButton FtoCRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahBox = findViewById(R.id.fahBox);
        celBox = findViewById(R.id.celBox);
        FtoCRadio = findViewById(R.id.FtoCRadio);
    }

    public void convert(View v) {
        if (FtoCRadio.isChecked()) {
            String input = fahBox.getText().toString();
            if(input.length()>0) {
                double fahValue = Double.parseDouble(input);
                double celValue = (fahValue - 32.0) * 5.0 / 9.0;
                celBox.setText(String.format("%.1f", celValue));
            } else{
                Toast.makeText(this, "No Fahrenheit value entered", LENGTH_SHORT).show();
            }
        }
        else {
            String input = celBox.getText().toString();
            if(input.length()>0) {
                double celValue = Double.parseDouble(input);
                double fahValue = (celValue * 9.0 / 5.0) + 32.0;
                fahBox.setText(String.format("%.1f", fahValue));
            } else{
                Toast.makeText(this, "No Celsius value entered", LENGTH_SHORT).show();
            }
        }
    }

}
