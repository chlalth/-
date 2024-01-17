package com.example.a2_main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] name={"1","2","3","4","5","6","7","8","9","10","11"};
    ArrayAdapter<String>arrayAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data);
    listView = findViewById(R.id.listView);
    arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
    listView.setAdapter(arrayAdapter);
    }
}