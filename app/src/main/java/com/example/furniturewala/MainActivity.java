package com.example.furniturewala;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
// Designing Main Layout
// CardView Design (Primary Cards)

    // primary Card
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    private Context mContext;

    // Secondary Cards
    private static RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager2;
    private static RecyclerView recyclerView2;
    private static ArrayList<DataModel> data2;
    private Context mContext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- Create main Cards
        InitiateMainCards();

        // 2- Create secondary Cards
        InitiateSecondaryCards();


    }



    private void InitiateMainCards() {
        //method for primary cards
        recyclerView = findViewById(R.id.recyclerViewPrimary);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Getting Data from MyData
       data = new ArrayList<DataModel>();
       for (int i=0;i<MyData.nameArray.length;i++){
          data.add(new DataModel(
                  MyData.nameArray[i],
                  MyData.versionArray[i],
                  MyData.id[i],
                  MyData.drawableArray[i]
          ));

       }
       // Let's add the Adapter (Custom Adapter )
        adapter = new CustomAdapter(data,this);
       recyclerView.setAdapter(adapter);
    }

    private void InitiateSecondaryCards() {
        recyclerView2 = findViewById(R.id.recyclerViewSecondary);
        recyclerView2.setHasFixedSize(true);

        layoutManager2 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        // getting data from myData2
        data2 = new ArrayList<>();
        for (int i=0; i<MyData2.nameArray.length; i++){
            data2.add(new DataModel(
                    MyData2.nameArray[i],
                    MyData2.versionArray[i],
                    MyData2.id[i],
                    MyData2.drawableArray[i]
            ));
        }
        adapter2 = new CustomAdapter2(data2,this);
        recyclerView2.setAdapter(adapter2);
    }
}