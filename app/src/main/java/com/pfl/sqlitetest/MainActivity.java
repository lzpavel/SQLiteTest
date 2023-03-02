package com.pfl.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pfl.sqlitetest.databinding.ActivityMainBinding;
import com.pfl.sqlitetest.db.MyDbManager;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MyDbManager myDbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myDbManager = new MyDbManager(this);

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDbManager.insertToDb(binding.editTextText.getText().toString());
                update();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        myDbManager.openDb();
        update();
    }

    private void update() {
        binding.textViewText.setText("");
        for (String s : myDbManager.readFromDb()) {
            binding.textViewText.append(s + "\n");
        }
    }

}