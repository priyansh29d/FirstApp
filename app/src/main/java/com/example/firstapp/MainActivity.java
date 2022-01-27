package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickHandler(View view) {
        Toast.makeText(this, "loggin in", Toast.LENGTH_SHORT).show();
    }
}