package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserLogIn extends AppCompatActivity {

    // declare the variables

    private EditText email ,password;
    private Button btn_login;
    private ProgressBar loading;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log_in);

        loading = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        //btnlog_out = findViewById(R.id.log_out);
        TextView link_register = findViewById(R.id.link_regist);


        // click listenr for logging a user

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if(!mEmail.isEmpty() || !mPass.isEmpty()){
                    logIn(mEmail, mPass);
                }else {
                    email.setError("Please insert an e-mail");
                    password.setError("Please insert a password");
                }
            }
        });

        link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserLogIn.this,MainActivity.class));
            }
        });


    }

    // method for login

    private void logIn(final String email, final String password) {

        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);

        String URL_LOGIN = "http://hop.logicalhive.com/Portal2/apis/login.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if (success.equals("1"))

                            {


                                for (int i = 0; i < jsonArray.length(); i++)
                                {

                                    JSONObject object = jsonArray.getJSONObject(i);


                                    String name = object.getString("username").trim();
                                    String email = object.getString("email").trim();
                                    String id = object.getString("id").trim();

                                    Toast.makeText(UserLogIn.this, "Success Login." +
                                            " \nYour Name: " + name + " \nYour Email: "
                                            + email, Toast.LENGTH_SHORT).show();
                                    sessionManager.createSession(email);


                                    Intent se = new Intent(UserLogIn.this,Dashboard.class);
                                    startActivity(se);

                                    loading.setVisibility(View.GONE);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            loading.setVisibility(View.GONE);
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(UserLogIn.this, "Error"+ e.toString(),
                                    Toast.LENGTH_SHORT).show();
                            Intent se = new Intent(UserLogIn.this, Dashboard.class);
                            startActivity(se);

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        loading.setVisibility(View.GONE);
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(UserLogIn.this, "Error"+ error.toString(),
                                Toast.LENGTH_SHORT).show();
                        Intent se = new Intent(UserLogIn.this, Dashboard.class);
                        startActivity(se);
                    }
                }
        )


        {
            //getting the parameters

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);




    }

}

