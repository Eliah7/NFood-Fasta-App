package com.eliahmbwilo.foodfasta;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eliahmbwilo on 2/14/18.
 */

public class LoginConnection extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "https://eliahmbwilocom.000webhostapp.com/login.php";
    private Map<String, String> params;

    public LoginConnection(String email, String password, Response.Listener<String> listener){

        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();

        params.put("email", email);
        params.put("password", password);

    }

    @Override
    public  Map<String, String> getParams(){
        return params;
    }
}

