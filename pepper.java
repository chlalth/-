package com.example.fit_fresh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class pepper extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gochu);
        final String[] itemNames = {"[항아골]전통장 세트",
                "[항아골]고추장(1kg/2kg)",
                "[항아골]된장, 고추장 세트(된장500g×1개+고추장500g×1개)"};
        final String[] url = {"https://chungjuc.com/product/%ED%95%AD%EC%95%84%EA%B3%A8%EC%A0%84%ED%86%B5%EC%9E%A5-%EC%84%B8%ED%8A%B8/489/category/26/display/1/"
                ,"https://chungjuc.com/product/%ED%95%AD%EC%95%84%EA%B3%A8%EA%B3%A0%EC%B6%94%EC%9E%A51kg2kg/91/category/26/display/1/",
                "https://chungjuc.com/product/%ED%95%AD%EC%95%84%EA%B3%A8%EB%90%9C%EC%9E%A5-%EA%B3%A0%EC%B6%94%EC%9E%A5-%EC%84%B8%ED%8A%B8%EB%90%9C%EC%9E%A5500g%C3%971%EA%B0%9C%EA%B3%A0%EC%B6%94%EC%9E%A5500g%C3%971%EA%B0%9C/92/category/26/display/1/"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_gochu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String selectedUrl = url[i];
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });
        b=(Button)findViewById(R.id.default_returnbutton);
        b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}
