package com.example.a17010233.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioGroup rg1;
    RadioGroup rg2;

    EditText etRJ;

    @Override
    protected void onPause() {
        super.onPause();

        int therg1 = rg.getCheckedRadioButtonId();
        int therg2 = rg1.getCheckedRadioButtonId();
        int therg3 = rg2.getCheckedRadioButtonId();
        String strRJ = etRJ.getText().toString();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = pref.edit();

        prefEdit.putInt("gp1",therg1);
        prefEdit.putInt("gp2",therg2);
        prefEdit.putInt("gp3",therg3);
        prefEdit.putString("myRJ",strRJ);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        int qns1 = pref.getInt("gp1",0);
        int qns2 = pref.getInt("gp2",0);
        int qns3 = pref.getInt("gp3",0);
        String msg = pref.getString("myRJ","");
        etRJ = findViewById(R.id.editTextRJ);
        rg = findViewById(R.id.group);
        rg1 = findViewById(R.id.group1);
        rg2 = findViewById(R.id.group2);

        etRJ.setText(msg);
        rg.check(qns1);
        rg1.check(qns2);
        rg2.check(qns3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDone = findViewById(R.id.buttonOK);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                // PASSING 1ST RP & SEE WHICH IS CHECK
                RadioGroup rg = findViewById(R.id.group);
                // Get the ID of the selected radio button in the Radio Group
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the ID we had gotten above
                RadioButton rb = findViewById(selectedButtonId);


                // PASSING 2ND RP & SEE WHICH IS CHECK
                RadioGroup rg1 = findViewById(R.id.group1);
                // Get the ID of the selected radio button in the Radio Group
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                // Get the radio button object from the ID we had gotten above
                RadioButton rb1 = findViewById(selectedButtonId1);


                // PASSING 3RD RP & SEE WHICH IS CHECK
                RadioGroup rg2 = findViewById(R.id.group2);
                // Get the ID of the selected radio button in the Radio Group
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                // Get the radio button object from the ID we had gotten above
                RadioButton rb2 = findViewById(selectedButtonId2);


                // PASSING EDIT TEXT
                EditText etRJ = findViewById(R.id.editTextRJ);
                String[] info = {rb.getText().toString(), rb1.getText().toString(), rb2.getText().toString(), etRJ.getText().toString()};

                Intent i = new Intent(MainActivity.this, Summary.class);
                i.putExtra("info", info);
                startActivity(i);
            }
        });

    }
}
