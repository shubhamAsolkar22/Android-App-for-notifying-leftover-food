package com.example.shubham.pingar;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Andro2DB extends AppCompatActivity {


    EditText name ;
    Button setLoc;

    private static String insert_url = "http://192.168.1.5/android%20to%20xampp/test_db.php";

    private static final String TAG_SUCCESS ="success";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_andro2_db);

        //edit text
        name = (EditText) findViewById(R.id.editText);

        //button
        setLoc = (Button) findViewById(R.id.button3);

        setLoc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                InsertSV();
            }
        });

    }
    private void InsertSV(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, insert_url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"great!!",Toast.LENGTH_LONG).show();
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<String, String>();
                String dname = name.getText().toString();
                params.put("n",dname);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
