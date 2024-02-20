package com.example.fit_fresh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bam_button;
    Button corn_b;
    Button pepper_b;
    Button peach_b;
    Button sp_b;
    Button apple_b;

    Button login_b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login_b=(Button) findViewById(R.id.button13);
        login_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent1= new Intent(getApplication(),login.class);
                startActivity(intent1);
            }
        });

        bam_button=(Button) findViewById(R.id.bam_image_button);
        bam_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent2= new Intent(getApplication(), bam.class);
                startActivity(intent2);
            }
        });

        corn_b=(Button) findViewById(R.id.conr_image_button);
        corn_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent3= new Intent(getApplicationContext(),corn.class);
                startActivity(intent3);
            }
        });

        pepper_b= (Button)findViewById(R.id.pepper_image_button);
        pepper_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent4= new Intent(getApplicationContext(),pepper.class);
                startActivity(intent4);
            }
        });
        peach_b= (Button)findViewById(R.id.peach_image_button);
        peach_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent5= new Intent(getApplicationContext(),peach.class);
                startActivity(intent5);
            }
        });
        sp_b= (Button)findViewById(R.id.sp_image_button);
        sp_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent6= new Intent(getApplicationContext(),sweet_potato.class);
                startActivity(intent6);
            }
        });
        apple_b=(Button) findViewById(R.id.apple);
        apple_b.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent7= new Intent(getApplicationContext(),apple.class);
                startActivity(intent7);
            }
        });




    }
}