package com.example.tempconvert;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ColorActivity extends AppCompatActivity {

    private RadioButton yellowButton;
    private RadioButton pinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        yellowButton = findViewById(R.id.yellowButton);
        pinkButton = findViewById(R.id.pinkButton);

    }

    @Override
    public void onBackPressed() {
        int color;
        if (yellowButton.isChecked())
            color = 0xffFFA000;
        else if (pinkButton.isChecked())
            color = 0xffFF9191;
        else
            color = 0xff73BFE6;
        Intent i = new Intent();
        i.putExtra("COLOR", color);
        setResult(RESULT_OK, i);
        finish();
    }

}
