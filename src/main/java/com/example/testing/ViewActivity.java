package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import com.example.testing.Sql.DBHelperItem;
import com.example.testing.Sql.ItemModel;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ArrayList<ItemModel> itemModalArrayList;
    private DBHelperItem dbHelperItem;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        // initializing our all variables.
        itemModalArrayList = new ArrayList<>();
        dbHelperItem = new DBHelperItem(ViewActivity.this);

        // getting our course array
        // list from db handler class.
        itemModalArrayList = dbHelperItem.readItem();

        // on below line passing our array list to our adapter class.
        courseRVAdapter = new CourseRVAdapter(itemModalArrayList, ViewActivity.this);
        coursesRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);

        // Applying OnClickListener to our Adapter
        courseRVAdapter.setOnClickListener(new CourseRVAdapter.OnClickListener() {
            @Override
            public void onClick(int position, ItemModel model) {
                // Handle the button click here.
                // You can navigate to UpdateActivity or perform any other action as needed.
                Intent intent = new Intent(ViewActivity.this, UpdateActivity.class);
                // Pass any data you need to the UpdateActivity.
                startActivity(intent);
            }
        });

    }
}


