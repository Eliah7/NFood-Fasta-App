package com.eliahmbwilo.foodfasta;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eliahmbwilo on 2/14/18.
 */

public class RegisterConnection extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "https://eliahmbwilocom.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterConnection(String username, String email, String password, Response.Listener listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }

}
