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

public class apple extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apple);
        final String[] itemNames = {"프레샤인 GAP 인증 충주 못난이사과",
        "선물용 충주 사과 3kg(13-14과)",
        "프레샤인 충주 GAP 인증 당도선별 사과"
        ,"고당도 충주 부사 사과 선물용 3kg 5kg"
        ,"충주 사과 산지직송 햇 부사 꿀사과 선물용 3kg 5kg 10kg 못난이사과 3kg(중) / 1..., 1박스"
        ,"충주사과 4.5kg 913과"
        ,"충주사과 부사사과 9kg 32~40과"};
        final String[] url = {"https://www.coupang.com/vp/products/5611991510?itemId=9072375286&vendorItemId=76358677658&src=1042503&spec=10304982&addtag=400&ctag=5611991510&lptag=10304982I9072375286&itime=20240123134549&pageType=PRODUCT&pageValue=5611991510&wPcid=17059218237735355146398&wRef=www.google.com&wTime=20240123134549&redirect=landing&gclid=&mcid=c6d882c8356e4583811525aaf460118e&campaignid=&adgroupid=&isAddedCart="
                ,"https://item.gmarket.co.kr/Item?goodscode=3147384365&GoodsSale=Y&jaehuid=200013954&srsltid=AfmBOor9LUAXY0kyn8H-ocBfKTFcpNIiEmO0cUn-RFg_Rb_-O8m8WZAnmCU"
        ,"https://www.coupang.com/vp/products/307819051?itemId=970605737&vendorItemId=5379874457&src=1042503&spec=10304982&addtag=400&ctag=307819051&lptag=10304982I970605737&itime=20240123134703&pageType=PRODUCT&pageValue=307819051&wPcid=17059218237735355146398&wRef=www.google.com&wTime=20240123134703&redirect=landing&gclid=&mcid=46d680ea76d8435f9147af0c3f2c8b98&campaignid=&adgroupid=&isAddedCart="
        ,"http://itempage3.auction.co.kr/DetailView.aspx?itemno=D788159906&BCODE=BN00256873&gate_id=b5fd9dbd-3e44-493f-8b5b-546f5702695d&ck=&sn=&igaw_eng=&airbridge_referrer=&appgate_guid="
        ,"https://www.coupang.com/vp/products/7715232288?itemId=20691642629&vendorItemId=87752683852&src=1042503&spec=70304777&addtag=400&ctag=7715232288&lptag=I20691642629V87752683852A400286468&itime=20240123134823&pageType=PRODUCT&pageValue=7715232288&wPcid=17059218237735355146398&wRef=www.google.com&wTime=20240123134823&redirect=landing&AdNodeId=400286468&gclid=&mcid=fb69cb39de924c1d8d01036c08325e72&campaignid=&adgroupid=&isAddedCart="
        ,"https://item.gmarket.co.kr/Item?goodscode=3471533867&GoodsSale=Y&jaehuid=200013954&srsltid=AfmBOorGXidchIQcpQnGzfxn110bAGaWRIz5mXa-shEsSUAKWF9dpfB2G84"
        ,"http://itempage3.auction.co.kr/DetailView.aspx?itemno=D825163890&BCODE=BN00256873&gate_id=1552801f-e7bc-4f19-ab98-05153e0e83e2&ck=&sn=&igaw_eng=&airbridge_referrer=&appgate_guid="};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_apple);
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