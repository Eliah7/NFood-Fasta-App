package com.eliahmbwilo.foodfasta;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private Button mSignIn;
    private Button mSignUp;

    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    private ProgressDialog mDialog;

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        String name = preferences.getString("name", "no username");
        String mail = preferences.getString("mail", "noemail@nodomain.com");

        if (TextUtils.isEmpty(name) && TextUtils.isEmpty(mail)){

        }else{
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDialog = new ProgressDialog(this);
        mDialog.setIndeterminate(false);
        mDialog.setCancelable(true);
        mDialog.setMessage("Loading. please wait...");


        mSignUp = (Button) findViewById(R.id.lg_create_account);
        mSignIn = (Button) findViewById(R.id.lg_btn);

        mEmail = (TextInputLayout) findViewById(R.id.lg_email);
        mPassword = (TextInputLayout) findViewById(R.id.lg_passcode);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        String email = mEmail.getEditText().getText().toString();
        String passcode = mPassword.getEditText().getText().toString();
        Response.Listener<String> responseListener = null;

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getEditText().getText().toString();
                String password = mPassword.getEditText().getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }else {

                    mDialog.show();

                    Response.Listener<String> responseListener = new Response.Listener<String>(){

                        @Override
                        public void onResponse(String response) {
                            try{
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success){

                                    mDialog.dismiss();

                                    String username = jsonResponse.getString("username");
                                    String email = jsonResponse.getString("email");
                                    String password = jsonResponse.getString("password");

                                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString("name", username);
                                    editor.putString("mail", email);
                                    editor.apply();


                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    LoginActivity.this.startActivity(intent);
                                    finish();

                                }else{
                                    mDialog.dismiss();
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("Login Failed").setNegativeButton("Retry", null).create().show();
                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    };

                    LoginConnection loginConnection = new LoginConnection(email, password, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginConnection);
                }
            }
        });


        LoginConnection loginRequest = new LoginConnection(email, passcode, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        queue.add(loginRequest);
    }
}

