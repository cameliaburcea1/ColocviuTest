package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import java.util.StringTokenizer;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Intent intent = getIntent();
        if(intent != null && intent.getExtras().containsKey("COMPUTE_SUM")) {
            int sum = 0;
            String sumString = intent.getStringExtra("COMPUTE_SUM");
            StringTokenizer st = new StringTokenizer(sumString, " +");
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }

            setResult(sum);
            finish();
        }

        setResult(RESULT_CANCELED);
        finish();
    }
}