package com.example.fit_fresh;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
    Button btn_login;
    Button join;
    EditText et_id, et_pass;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        join=(Button)findViewById(R.id.btn_register);

        btn_login=(Button) findViewById(R.id.btn_login);

        join=(Button)findViewById(R.id.btn_register);
        join.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent2= new Intent(getApplication(), join.class);
                startActivity(intent2);
            }
        });



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userID=et_id.getText().toString();
                String userPass=et_pass.getText().toString();

                //서버 응답에 대한 리스너 역할을 함 (문자열 형식의 응답을 처리함)
                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    //서버 응답이 도착했을 떄 호출되는 메서드를 정의
                    public void onResponse(String response) {
                        try {
                            //서버의 응답을 JSONObject로 변환  (JSON 형식의 데이터를 다루기 위한 객체임)
                            JSONObject jasonObject=new JSONObject(response);
                            //JSON 객체에서 "success"라는 키의 값을 가져와서 해당 값이 참 거짓인지 나타내는 boolena 변수인 'success'에 저장
                            boolean success=jasonObject.getBoolean("success");
                            if (success) {//회원등록 성공한 경우
                                //JSON 객체에서 "userID"라는 키의 값을 가져와서 해당 값을 문자열 변수 'userID'에 저장함
                                String userID = jasonObject.getString("userID");
                                String userPass = jasonObject.getString("userPassword");
                                //사용자에게 짧은 메세지를 표시하는 안드로이드 Toast 생성하여 "로그인 성공" 메시지 표시
                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(login.this, MainActivity.class);
                                //"log"라는 키로 "User"라는 문자열 데이터를 Intent에 추가
                                intent.putExtra("log", "User");
                                //"userID"라는 키로 앞에서 가져온 사용자 ID를 Intent에 추가
                                intent.putExtra("userID", userID);
                                //생성한 Intent 사용하여 새로운 엑티비티를 시작함
                                startActivity(intent);
                            }


                            else{//회원등록 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                return;

                            }
                        } catch (JSONException e) {
                            //예외 발생 시 해당 예외의 스택 트레이스를 출력
                            e.printStackTrace();
                        }
                    }
                };
                //LoginRequest 클래스의 새로운 인스턴스 생성
                //서버로 로그인 요청을 보내는데 필요한 정보를 포함
                //생성자에 id, password 그리고 서버 응답을 처리할 리스너 (responseListener) 전달됨
                LoginRequest loginRequest=new LoginRequest(userID,userPass,responseListener);
                //ReQuestQueue -> 서버와 통신하기 위해 요청을 대기열에 추가하고 관리하는 객체
                //Volley.newRequestQueue(LoginActivity.this); -> Volley 라이브러리를 사용하여 새로운 요청 큐를 생성
                //LoginActivity.this -> 현재 엑티비티의 컨텍스트를 전달하는 것으로 엑티비티의 라이프사이클에 맞게 요청 큐 생성
                RequestQueue queue= Volley.newRequestQueue(login.this);
                //앞서 생서한 loginRequest를 요청 큥에 추가
                //Volley 라이브러리가 해당 요청을 서버로 보내고 서버의 응답은 앞서 정의한 responseListener를 통해 처리됨
                queue.add(loginRequest);
            }
        });
    }
}




