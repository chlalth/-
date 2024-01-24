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

public class bam extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bam);
        final String[] itemNames = {"에코후레쉬 ★무료배송★ [충주] 이평밤 500g/2kg/4kg 골라담기",
        "충주밤(대)2kg/겉껍질만 깐밤1.5kg/ 맛 100%보장",
        "동충주농협 소태밤 대 사이즈 4kg",
        "[산지직송] 충주 김의충님의 유기농 알밤(특) 2kg\n" +
                "주원료/원산지 : 밤/국내산"};
        final String[] url = {"https://eco-fresh.co.kr/product/detail.html?product_no=64108&cafe_mkt=ue_Gshopping_living&srsltid=AfmBOoqkX6pN2ALSRAN86yoSqHLd5XmL_tl6LKASuQPpUo_DE9TURpxCEDo",
        "https://item.gmarket.co.kr/Item?goodscode=1548959704&GoodsSale=Y&jaehuid=200013954&srsltid=AfmBOoqE4I97IdRlnTxfYfDcpQ7EvMfiUIsaUUhR8Xg4sdS69jAytvV48m4"
        ,"https://www.11st.co.kr/products/6709640314?srsltid=AfmBOopVh3b5GWm2Qc5wkXWjbYkTeK1q-vp4Hqg6cG2l8jW49j55iZUJBrw&utm_term=&utm_campaign=googleshopping_pc_basic_new&utm_source=%B1%B8%B1%DB_PC_S_%BC%EE%C7%CE&utm_medium=%B0%CB%BB%F6",
        "http://www.hnsmall.com/display/goods.do?goods_code=19383586&channel_code=21323&utm_source=Google_Shopping&utm_medium=SA&utm_campaign=Dynamic"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_bam);
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