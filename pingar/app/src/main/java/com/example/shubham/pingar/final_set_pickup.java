package com.example.shubham.pingar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

import java.util.HashMap;
import java.util.Map;

public class final_set_pickup extends AppCompatActivity {

    EditText name,contactnum,server_url;
    Button set;
    String ackname;

    //change ip address by checking it using'ipconfig' in cmd
    private static String insert_url ;   //server_url.getText().toString()                     //"http://192.168.1.4/android%20to%20xampp/conn2xamp.php"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_set_pickup);

        name = (EditText) findViewById(R.id.donorName);
        contactnum = (EditText) findViewById(R.id.contactno) ;
        server_url = (EditText) findViewById(R.id.server_ip);
        set = (Button) findViewById(R.id.setButton);

        set.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                InsertPL();
                //testing_location.flag =0;
            }
        });
    }

    private void InsertPL(){
        StringRequest strRequest = new StringRequest(Request.Method.POST,server_url.getText().toString(), new Response.Listener<String>() {   //parameter 2 was : insert_url
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"great!!",Toast.LENGTH_LONG).show();
                Intent n = new Intent(final_set_pickup.this,ACKscreen.class);
                n.putExtra("ackmsg",name.getText().toString());
                startActivity(n);
            }

        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            } }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String dname = name.getText().toString();
                String cont_no = contactnum.getText().toString();
                Bundle b = getIntent().getExtras();
                String lat = new String(b.getString("lat"));
                String lng = new String(b.getString("lng"));


                params.put("yourName", dname);
                params.put("latitude",lat);
                params.put("longitude",lng);
                params.put("cno",cont_no);


                return params;
            }};
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strRequest);

    }

}
