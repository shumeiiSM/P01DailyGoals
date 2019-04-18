package com.example.a17010233.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        // Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        // Get the TextView object
        TextView tv1 = findViewById(R.id.textView1);
        // Display the name and age on the TextView
        tv1.setText(getString(R.string.g) + " : "  + info[0] +
                "\n\n" + getString(R.string.g1) + " : " + info[1] +
                "\n\n" + getString(R.string.g2) + " : " + info[2] +
                "\n\nReflection: " + info[3]);

        btn = findViewById(R.id.buttonClose);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
