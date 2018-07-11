package com.example.shubham.pingar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ACKscreen extends AppCompatActivity {

    TextView donor_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ackscreen);

        donor_name = (TextView) findViewById(R.id.textView4) ;


        Bundle b = getIntent().getExtras();
        String msg = new String(b.getString("ackmsg"));
        donor_name.setText(msg);

    }

    public void closeapp(View v){
        finish();
        System.exit(0);
    }
}
