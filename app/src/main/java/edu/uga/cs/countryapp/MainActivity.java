package edu.uga.cs.countryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import edu.uga.cs.countryapp.R;

public class MainActivity extends AppCompatActivity {

    private Button overviewButton;
    private Button detailsButton;
    private Spinner countrySpinner;
    private int spinnerPos;
    public static final String COUNTRY = "edu.uga.cs.countryapp.COUNTRY";
    public enum Country {USA, ISRAEL, CANADA, UKRAINE, JAPAN}

    private Country selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obtain references to UI objects
        overviewButton = findViewById(R.id.button);
        detailsButton = findViewById(R.id.button2);
        countrySpinner = findViewById(R.id.spinner);

        // set the listener for the spinner
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (((String)adapterView.getItemAtPosition(i)).equals("USA")) {
                    selectedCountry = Country.USA;
                }
                else if (((String)adapterView.getItemAtPosition(i)).equals("Israel")) {
                    selectedCountry = Country.ISRAEL;
                }
                else if (((String)adapterView.getItemAtPosition(i)).equals("Canada")) {
                    selectedCountry = Country.CANADA;
                }
                else if (((String)adapterView.getItemAtPosition(i)).equals("Ukraine")) {
                    selectedCountry = Country.UKRAINE;
                }
                else if (((String)adapterView.getItemAtPosition(i)).equals("Japan")) {
                    selectedCountry = Country.JAPAN;
                }
                spinnerPos = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        overviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), OverviewActivity.class);
                intent.putExtra("Country", selectedCountry);
                view.getContext().startActivity(intent);
            }
        });

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra("Country", selectedCountry);
                view.getContext().startActivity(intent);
            }
        });
    }
}