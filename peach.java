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

public class peach extends AppCompatActivity {
    Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peach);
        final String[] itemNames = {"충주복숭아 대명,유명,(14-16과)딱딱한복숭아",
                "충주 복숭아 천도 백도 복숭아 풍부한 맛과향 식감 좋은 신선 달콤한 복숭아 3kg [원산지:국산(충청북도 충주시)]",
                "충주 황금알 복숭아 엘바트 양홍장 황도 3kg 2.5kg 황도말랑이, 1개"
        ,"충주원예조경 / 황도복숭아나무 / 접목1년 / 1등묘",
        "충주 하늘작 백도 황도 말랑이 딱딱이 털 3kg"};
        final String[] url = {"https://www.juhofarm.com/FrontStore/iGoodsView.phtml?iGoodsId=0003_00007&iPriceIDX=0",
                "https://smartstore.naver.com/applecj/products/5008620955?NaPm=ct%3Dlrotrfio%7Cci%3Dc2da235cbe2321aa423d230c37676adc528b9cf6%7Ctr%3Dsls%7Csn%3D1059451%7Chk%3Da64f9abfbfaee5459c811ed1814673a90557c65e",
                "https://www.coupang.com/vp/products/7603097291?itemId=20117613635&vendorItemId=85953040881&src=1032001&spec=10305199&addtag=400&ctag=7603097291&lptag=I20117613635&itime=20240122201023&pageType=PRODUCT&pageValue=7603097291&wPcid=17059218237735355146398&wRef=cr2.shopping.naver.com&wTime=20240122201023&redirect=landing&mcid=b006c02e37814cb98ee4f1ad0b05d5c3&isAddedCart=",
        "https://item.gmarket.co.kr/Item?goodscode=3471284843&GoodsSale=Y&jaehuid=200001169&NaPm=ct%3Dlrotu9dc%7Cci%3D2cf6187bed1b5ab9653a23b9dbe4c17d950c2f05%7Ctr%3Dsls%7Csn%3D24%7Chk%3Ddb9952ad52ee77dcf0394601745fae120ad9476b",
        "https://www.tmon.co.kr/deal/22350390314?NaPm=ct%253Dlrotvl7k%257Cci%253D36e50dcae85aba3b07e13b0119e6bce7418f68f5%257Ctr%253Dslsl%257Csn%253D221844%257Chk%253Dd1ff28438cc5f688f3451b6f47c12188a4d66573&tmonProcess=entryPath&coupon_srl=3339630&utm_source=naver&utm_medium=affiliate&utm_term=72093_1008&utm_content=&utm_campaign=META_%EB%84%A4%EC%9D%B4%EB%B2%84%EC%A7%80%EC%8B%9D%EC%87%BC%ED%95%91"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);

        ListView listView = findViewById(R.id.lv_peach);
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
