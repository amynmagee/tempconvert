package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private EditText fahBox;
    private EditText celBox;
    private RadioButton FtoCRadio;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        fahBox = findViewById(R.id.fahBox);
        celBox = findViewById(R.id.celBox);
        FtoCRadio = findViewById(R.id.FtoCRadio);
        celBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                convert(v);
                return false;
            }
        });
        fahBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                convert(v);
                return false;
            }
        });
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

    public void colorPressed(View v){
        Intent i = new Intent(this, ColorActivity.class);
        startActivityForResult(i, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int color = data.getIntExtra("COLOR",0xffffffff);
        layout.setBackgroundColor(color);
    }
}
