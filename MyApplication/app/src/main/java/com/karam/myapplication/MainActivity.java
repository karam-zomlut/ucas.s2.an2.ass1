package com.karam.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}
