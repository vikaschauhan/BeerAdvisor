package com.example.android.beeradvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Add a instance of BeerExpert as a private variable
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Call when the button gets clicked
    public void onClickFindBeer(View view) {
        // Get a Reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a Reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        // Get the selected item in the Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Get recommendations from the Beer Expert Class

        // get the list of brands
        List<String> brandsList = expert.getBrands(beerType);

        // Build a String using the value in the List
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        // Display the beer
        // Display the beer in the TextView
        brands.setText(brandsFormatted);

//        // Display the selected item
//        brands.setText(beerType);

    }
}
