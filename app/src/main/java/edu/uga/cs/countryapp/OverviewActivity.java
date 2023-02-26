package edu.uga.cs.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OverviewActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "Overview";
    private MainActivity.Country countrySelected;
    private StringBuilder text = new StringBuilder();
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        textView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView4);

        Intent intent = getIntent();
        countrySelected = (MainActivity.Country) intent.getSerializableExtra("Country");
        Log.d(DEBUG_TAG, countrySelected.toString());
        
        displayTextFile();
        displayFlag();
    }
    private void displayTextFile(){
        BufferedReader reader = null;
        try {
            if (countrySelected == MainActivity.Country.USA) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.usa_overview)));
            }
            else if (countrySelected == MainActivity.Country.JAPAN) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.japan_overview)));
            }
            else if (countrySelected == MainActivity.Country.UKRAINE) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.ukraine_overview)));
            }
            else if (countrySelected == MainActivity.Country.ISRAEL) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.israel_overview)));
            }
            else if (countrySelected == MainActivity.Country.CANADA) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.canada_overview)));
            }

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error reading file!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
            textView.setText((CharSequence) text);
        }
    }

    private void displayFlag() {
        if (countrySelected == MainActivity.Country.USA) {
            imageView.setImageDrawable(getDrawable(R.drawable.flag_of_usa));
        }
        else if (countrySelected == MainActivity.Country.JAPAN) {
            imageView.setImageDrawable(getDrawable(R.drawable.flag_of_japan));
        }
        else if (countrySelected == MainActivity.Country.UKRAINE) {
            imageView.setImageDrawable(getDrawable(R.drawable.flag_of_ukraine));
        }
        else if (countrySelected == MainActivity.Country.ISRAEL) {
            imageView.setImageDrawable(getDrawable(R.drawable.flag_of_israel));
        }
        else if (countrySelected == MainActivity.Country.CANADA) {
            imageView.setImageDrawable(getDrawable(R.drawable.flag_of_canada));
        }
    }
}