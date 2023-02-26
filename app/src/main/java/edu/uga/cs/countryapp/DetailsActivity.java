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
import java.io.InputStreamReader;

public class DetailsActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "Details";
    private MainActivity.Country countrySelected;
    private StringBuilder text = new StringBuilder();
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = findViewById(R.id.textView4);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        countrySelected = (MainActivity.Country) intent.getSerializableExtra("Country");
        Log.d(DEBUG_TAG, countrySelected.toString());

        displayTextFile();
        displayImage();
    }

    private void displayTextFile(){
        BufferedReader reader = null;
        try {
            if (countrySelected == MainActivity.Country.USA) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.usa_details)));
            }
            else if (countrySelected == MainActivity.Country.JAPAN) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.japan_details)));
            }
            else if (countrySelected == MainActivity.Country.UKRAINE) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.ukraine_details)));
            }
            else if (countrySelected == MainActivity.Country.ISRAEL) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.israel_details)));
            }
            else if (countrySelected == MainActivity.Country.CANADA) {
                reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.canada_details)));
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

    private void displayImage() {
        if (countrySelected == MainActivity.Country.USA) {
            imageView.setImageDrawable(getDrawable(R.drawable.washington_dc));
        }
        else if (countrySelected == MainActivity.Country.JAPAN) {
            imageView.setImageDrawable(getDrawable(R.drawable.tokyo));
        }
        else if (countrySelected == MainActivity.Country.UKRAINE) {
            imageView.setImageDrawable(getDrawable(R.drawable.kiev));
        }
        else if (countrySelected == MainActivity.Country.ISRAEL) {
            imageView.setImageDrawable(getDrawable(R.drawable.jerusalem));
        }
        else if (countrySelected == MainActivity.Country.CANADA) {
            imageView.setImageDrawable(getDrawable(R.drawable.ottawa));
        }
    }
}