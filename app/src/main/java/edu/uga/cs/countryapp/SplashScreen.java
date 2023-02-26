package edu.uga.cs.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.uga.cs.countryapp.R;

public class SplashScreen extends AppCompatActivity {

    private Button viewCountriesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        viewCountriesButton = findViewById(R.id.button3);

        viewCountriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}