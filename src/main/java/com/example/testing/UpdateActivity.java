package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.example.testing.Sql.DBHelperItem;
import com.example.testing.Sql.ItemModel;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    static ListView listView ;

    private ArrayList<ItemModel> itemModalArrayList;
    private DBHelperItem dbHelperItem;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }
}