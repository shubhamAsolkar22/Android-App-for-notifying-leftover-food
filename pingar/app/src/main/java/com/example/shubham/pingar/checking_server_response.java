package com.example.shubham.pingar;

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

public class checking_server_response extends AppCompatActivity {

    EditText name;
    Button set;

    //change ip address by checking it using'ipconfig' in cmd
    private static String insert_url = "http://192.168.1.4/MarkAsCollected/connectionToAndro.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_set_pickup);

        name = (EditText) findViewById(R.id.editText2);
        set = (Button) findViewById(R.id.button5);

       /*set.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                InsertPL();
            }
        }); */
    }
/*
    private void InsertPL(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, insert_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
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

                String lat = new String("12121");
                String lng = new String("3343444");


                params.put("yourName", dname);
                params.put("latitude",lat);
                params.put("longitude",lng);


                return params;
            }};
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(strRequest);

    }
*/
}
