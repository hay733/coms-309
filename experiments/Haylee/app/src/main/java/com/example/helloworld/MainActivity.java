package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NEW CODE FOR THE BUTTON
        //add a listener for the main page button
        Button nextButton = (Button)findViewById(R.id.activity_main_buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondPage();
            }
        });
    }

    // METHOD TO MOVE TO THE NEXT PAGE
    private void goToSecondPage() {
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }
}