package com.karam.sem2firstweek;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showInfoBtn = findViewById(R.id.showInfoBtn);
        EditText nameEt = findViewById(R.id.nameEt);
        EditText ageEt = findViewById(R.id.ageEt);
        CheckBox marriedCb = findViewById(R.id.marriedCb);
        TextView resultTv = findViewById(R.id.resultTv);
        RadioGroup genderRg = findViewById(R.id.genderRg);
        Spinner citiesSp = findViewById(R.id.citiesSp);


        showInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEt.getText().toString();
                int age = 2023 - Integer.parseInt(ageEt.getText().toString());
                String status = marriedCb.isChecked() ? "Married" : "Single";
                String gender;
                String city = (String) citiesSp.getSelectedItem();

                if (genderRg.getCheckedRadioButtonId() == R.id.maleRb) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                resultTv.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Status: " + status + "\n" + "Gender: " + gender + "\n" + "City: " + city);
            }
        });

        resultTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTv.setTextColor(Color.parseColor("#ff0000"));
            }
        });
    }
}