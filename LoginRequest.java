package com.example.fit_fresh;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 url 설정(php파일 연동)
    final static  private String URL="http://computernano.dothome.co.kr/Login.php";
    private Map<String,String>map;

    //LoginRequest -> 클래스의 생성자를 정의
    //id, password, 서버 응답을 처리할 리스너가 매개변수로 전달됨
    public LoginRequest(String userID, String userPassword, Response.Listener<String>listener){
        //부모 클래스인 StringRequest 의 생성자 호출
        //세 번째 매개변수는 서버 응답을 처리할 리스너임
        //여기서 null은 요청 본문 데이터로 여기서는 null로 설정하고 대신 getParams() 메서드를 통해 데이터를 설정
        super(Method.POST,URL,listener,null);

        //map 객체 초기화
        map=new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);

    }

    //부모 클래스인 StringRequest 에서 상속받은 메서드를 재정의함
    //post 방식으로 데이터를 서버에 보낼 떄 호출되어야 하는데 여기서는 map에 담긴 데이터를 반환 -> 이 데이터는 요청 본문에 실려서 서버로 전송됨
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
