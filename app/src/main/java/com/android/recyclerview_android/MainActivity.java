package com.android.recyclerview_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    SearchView searchView;
    RecyclerView recyclerView;

    List<Item> itemList;

    PassUpdatenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        searchView=findViewById(R.id.searchView);
        searchView.clearFocus();
        recyclerView = findViewById(R.id.passUpdatenRecyclerView);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });



        itemList = new ArrayList<>();
        Item item1 = new Item("hassen","12345");
        Item item2 = new Item("slimen","654321");
        Item item3 = new Item("ahmed","0000000");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);
        itemList.add(item3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new PassUpdatenAdapter(itemList);
        recyclerView.setAdapter(adapter);


        adapter.setClickListener(this);



    }



    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this,
                "You Choose: "+ itemList.get(pos).getName(),
                Toast.LENGTH_SHORT).show();

    }

    private void filterList(String text) {

        List<Item> filteredList = new ArrayList<>();
        for(Item item : itemList){
            if(item.getName().toLowerCase().contains(text.toLowerCase())||
                    item.getAusweisNr().contains(text))
                filteredList.add(item);
        }
        if (!filteredList.isEmpty()){
            adapter.setFilteredList(filteredList);

        }

    }

    }
