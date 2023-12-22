package com.example.restaurant_finder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.restaurant_finder.MyAdapter.MyAdapter;
import com.example.restaurant_finder.model.Magasin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Magasin> listMagasin;

    private Spinner citySpinner;
    private List<Magasin> originalListMagasin; // Original list to reset the RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // RecyclerView
        listMagasin = new ArrayList<>();
        listMagasin.add(new Magasin("res1", "Safi", 7777777));
        listMagasin.add(new Magasin("res2", "Casa", 7777777));
        listMagasin.add(new Magasin("res2", "tanger", 777777));
        originalListMagasin = new ArrayList<>(listMagasin); // Save the original list

        MyAdapter myadapter = new MyAdapter(listMagasin);
        recyclerView.setAdapter(myadapter);

        // Spinner
        citySpinner = findViewById(R.id.citySpinner);

        String[] newcities = getResources().getStringArray(R.array.cities_array);
        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, newcities);
        spinnerAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        citySpinner.setAdapter(spinnerAdapter);

        // Set listener for Spinner item selection
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected city from the Spinner
                String selectedCity = parent.getItemAtPosition(position).toString();

                // Filter the RecyclerView based on the selected city
                filterRecyclerView(selectedCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected (if needed)
            }
        });
    }

    // Helper method to filter RecyclerView based on the selected city
    private void filterRecyclerView(String selectedCity) {
        List<Magasin> filteredList = new ArrayList<>();

        for (Magasin magasin : originalListMagasin) {
            if (magasin.getAdress().equalsIgnoreCase(selectedCity)) {
                filteredList.add(magasin);
            }
        }

        // Update the RecyclerView with the filtered data
        adapter.setMagasins(filteredList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == R.id.contact) {
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemid == R.id.aide) {
            Toast.makeText(this, "Aide", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
