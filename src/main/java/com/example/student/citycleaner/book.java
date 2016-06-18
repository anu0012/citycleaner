package com.example.student.citycleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuragsharma.
 */
public class book extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String item;
    public static String a;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.book_center);

        Button b8=(Button)findViewById(R.id.button8);

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (item.equals("Andhara Pradesh")) {
                    a = "Andhara Pradesh";
                    Intent myIntent = new Intent(book.this, Andhara.class);
                    book.this.startActivity(myIntent);
                } else if (item.equals("Chhattisgarh")) {
                    a = "Chhattisgarh";
                    Intent myIntent = new Intent(book.this, Chhattisgarh.class);
                    book.this.startActivity(myIntent);
                } else if (item.equals("Gujarat")) {
                    a = "Gujarat";
                    Intent myIntent = new Intent(book.this, Gujrat.class);
                    book.this.startActivity(myIntent);
                } else if (item.equals("Rajasthan")) {
                    a = "Rajasthan";
                    Intent myIntent = new Intent(book.this, Rajasthan.class);
                    book.this.startActivity(myIntent);
                }
            }
        });
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        List<String> categories = new ArrayList<String>();
        categories.add("Andhara Pradesh");
        categories.add("Chhattisgarh");
        categories.add("Gujarat");
        categories.add("Rajasthan");




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();




        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Press Submit", Toast.LENGTH_LONG).show();

    }




    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
