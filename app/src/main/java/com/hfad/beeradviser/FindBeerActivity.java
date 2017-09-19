package com.hfad.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view){
        TextView text = (TextView) findViewById(R.id.brands);
        Spinner spinner = (Spinner) findViewById(R.id.color);

        String beerColor = String.valueOf(spinner.getSelectedItem());

        List<String> beerTypeList = expert.getBrands(beerColor);

        StringBuilder builder = new StringBuilder();
        for(String s : beerTypeList){
            builder.append(s + "\n");
        }

        text.setText(String.valueOf(builder));
    }
}
