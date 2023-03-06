package com.karam.ass1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button submitBtn, hiddenBtn;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        submitBtn = findViewById(R.id.submitBtn);
        hiddenBtn = findViewById(R.id.hiddenBtn);
        resultTv = findViewById(R.id.resultTv);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                resultTv.setText(inputText);
            }
        });

        hiddenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = resultTv.getVisibility();
                if (visibility == View.VISIBLE) {
                    resultTv.setVisibility(View.INVISIBLE);
                } else {
                    resultTv.setVisibility(View.VISIBLE);
                }
            }
        });

        resultTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTv.setTextColor(Color.parseColor("#ff0000"));
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        resultTv.setVisibility(View.VISIBLE);
        resultTv.setText(editText.getText().toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", editText.getText().toString());
        outState.putInt("color", resultTv.getCurrentTextColor());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("name", "null");
        int color = savedInstanceState.getInt("color", 0);
        resultTv.setTextColor(color);
        resultTv.setText(name);
    }
}