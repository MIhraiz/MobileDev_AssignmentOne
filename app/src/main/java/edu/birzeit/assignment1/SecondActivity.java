package edu.birzeit.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView edtDis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edtDis = findViewById(R.id.edtDisplay);
        Intent intent = getIntent();
        String l1 = "Name:  " + intent.getStringExtra("Name") + "\n";
        String l2 = "Email:  " + intent.getStringExtra("Email") + "\n";
        String l3 = "Password:  " + intent.getStringExtra("Pass") + "\n";
        String l4 = "Language:  " + intent.getStringExtra("Lang") + "\n";
        String l5 = "Gender:  " + intent.getStringExtra("Gender") + "\n\n\n\n";
        String l6 = "Thank You for testing the App";

        edtDis.setText(l1+l2+l3+l4+l5+l6);



    }
}