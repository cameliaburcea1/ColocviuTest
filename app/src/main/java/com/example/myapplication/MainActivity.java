package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button computeButton;

    EditText editText1;
    EditText allTerms;

    Boolean sumIsComputed;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add);
        editText1 = findViewById(R.id.edittext1);
        allTerms = findViewById(R.id.AllTerms);
        computeButton = findViewById(R.id.compute);

        sum = 0;

        addButton.setOnClickListener(view -> {
            if(!editText1.getText().toString().isEmpty()) {
                String newNumber = editText1.getText().toString();
                if (allTerms.getText().toString().isEmpty()) {
                    allTerms.setText(newNumber);
                } else {
                    allTerms.setText(allTerms.getText().toString() + "+ " + newNumber);
                }
                editText1.setText(null);
                sumIsComputed = false;
            }
        });

        computeButton.setOnClickListener(view -> {
            if(!sumIsComputed) {
                Intent intent = new Intent(getApplicationContext(), SecondaryActivity.class);
                intent.putExtra("COMPUTE_SUM", allTerms.getText().toString());
                startActivityForResult(intent, 1);
                sumIsComputed = true;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode != RESULT_CANCELED) {
            sum = requestCode;
            Toast.makeText(this, "Sum is " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);


    }
}