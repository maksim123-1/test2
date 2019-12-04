package com.example.mysimplebank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StartActivity extends AppCompatActivity {
Button registration,avtorization,reg;
EditText login,password,firstname,lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        registration=findViewById(R.id.registration);
        avtorization=findViewById(R.id.avtorization);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(StartActivity.this);
                final View mdialog=getLayoutInflater().inflate(R.layout.registration,null);
reg=mdialog.findViewById(R.id.reg);
reg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        login=mdialog.findViewById(R.id.login);
        password=mdialog.findViewById(R.id.password);
        firstname=mdialog.findViewById(R.id.firstname);
        lastname=mdialog.findViewById(R.id.lastname);

        login();

    }
});


                    dialog.setView(mdialog);
                AlertDialog alertDialog=dialog.create();
                alertDialog.show();

            }
        });



        avtorization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }


    public void login(){
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.74:8080/get-login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(StartActivity.this,response,Toast.LENGTH_SHORT).show();

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


}
