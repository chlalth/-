package com.example.fit_fresh;

import androidx.appcompat.app.AlertDialog;
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

public class join extends AppCompatActivity {
    private EditText et_id, et_pass, et_name, et_age,  et_passck;
    private Button btn_register, validateButton;
    private AlertDialog dialog;
    private boolean validate = false;
    private Button return_login;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_passck = findViewById(R.id.et_passck);
        validateButton = findViewById(R.id.validateButton);

        return_login=(Button) findViewById(R.id.default_returnbutton);
        return_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent1= new Intent(getApplication(), login.class);
                startActivity(intent1);
            }
        });

        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = et_id.getText().toString();
                //validate 플래그가 이미 설정되어 있는지 확인
                //이미 설정 되어있으면 -> 사용자가 이미 중복 id를 확인한 것이므로 플래그를 재설정
                //다음 메서드에서 반환
                if (validate) {
                    validate = false;
                    validateButton.setText("중복 확인");
                    return;
                }
                //입력된 사용자 id가 빈 문자열인지 확인
                //비어 있다면 -> 비어 있을 수 없다는 내용의 alertDialog를 표시하고 메서드에서 반환
                if (userID.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                    dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }
                //volley를 사용하여 중복 확인 요청을 한 후 서버에서의 응답을 처리하기 위한 Response.Listener을 정의
                //Response.Listener<String> 를 구현하는 새로운 객체 생성
                //volley 라이브러리를 사용하여 네트워크 요청의 응답 처리에 사용
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //서버에서 받은 문자열 응답을 'JSONObject(response)'로 변환
                            JSONObject jsonResponse = new JSONObject(response);
                            //JSON 객체에서 success 키에 해당하는 값을 가져와서 success 변수에 저장
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                //alertDialog를 새엇ㅇ하는 AlertDialog.Builder 객체를 만듦
                                //RegisterActivity.this는 현재의 RegisterActivity를 참조
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                //aleterDialog 에 표시할 메시지 작성
                                //확인 버튼을 설정하며, 이 경우에는 '확인'을 눌렀을 떄 아무 동작도 수행하지 않도록 null을 전달
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                //alertDialog를 화면에 표시
                                dialog.show();
                                //사용자 id 입력란을 비활성화
                                et_id.setEnabled(false);
                                validate = true;
                                validateButton.setText("확인");
                            } else {
                                //다시 AlertDialog를 생성하는 AlertDialog.Builder 객체를 만듦
                                AlertDialog.Builder builder = new AlertDialog.Builder(join.this);
                                dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(userID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(join.this);
                queue.add(validateRequest);
            }
        });

        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                final String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());
                final String PassCk = et_passck.getText().toString();

                // 비밀번호 일치 여부 확인
                if (!userPass.equalsIgnoreCase(PassCk)) {
                    Toast.makeText(getApplicationContext(), "비밀번호와 확인이 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "회원 등록 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(join.this, login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "회원 등록 실패", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(join.this);
                queue.add(registerRequest);
            }
        });

    }
}