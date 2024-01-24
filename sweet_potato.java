package com.example.fit_fresh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class sweet_potato extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sweet_potato);
        final String[] itemNames = {"충주 고구마한박스 베니하루까 10kg 개당 100~180g 꿀고구마 베니하루카",
                "[구룡농원]유기농 고구마말랭이(100g×10봉)","[구룡농원]100% 유기농 꿀 고구마(3kg 혼합)"};
        final String[] url = {"https://www.gmarket.co.kr/challenge/neo_jaehu/jaehu_goods_gate.asp?goodscode=2693873967&GoodsSale=Y&jaehuid=200001169&NaPm=ct%3Dlrotxink%7Cci%3Dbe46cd73533e3281a15f19f8e3d61e3b8f39dc70%7Ctr%3Dsls%7Csn%3D24%7Chk%3Da0330b068fc0bb7193bcfc48febefd322abfe77e",
        "https://chungjuc.com/product/%EA%B5%AC%EB%A3%A1%EB%86%8D%EC%9B%90%EC%9C%A0%EA%B8%B0%EB%86%8D-%EA%B3%A0%EA%B5%AC%EB%A7%88%EB%A7%90%EB%9E%AD%EC%9D%B4100g%C3%9710%EB%B4%89/188/category/27/display/1/","https://chungjuc.com/product/%EA%B5%AC%EB%A3%A1%EB%86%8D%EC%9B%90100-%EC%9C%A0%EA%B8%B0%EB%86%8D-%EA%BF%80-%EA%B3%A0%EA%B5%AC%EB%A7%883kg-%ED%98%BC%ED%95%A9/189/category/24/display/1/"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_sp);
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
