package com.example.mruma.hackerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BoxDetail extends AppCompatActivity {
    private Handler handler = new Handler();
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_detail);


        showDialog();
    }

    public void showDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password");
        builder.setMessage("Password to network:hN6Ejkh");

        builder.setPositiveButton("Copy", new DialogInterface.OnClickListener()

        {
            public void onClick(DialogInterface dialog, int id) {

                Toast.makeText(getApplicationContext(), "Copy", Toast.LENGTH_LONG).show();
                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                setIntent.addCategory(Intent.CATEGORY_HOME);
                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(setIntent);
               finish();


            }
        });
        builder.setNegativeButton("ok", new DialogInterface.OnClickListener()

        {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
                Intent setIntent = new Intent(Intent.ACTION_MAIN);
                setIntent.addCategory(Intent.CATEGORY_HOME);
                setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(setIntent);
                finish();
            }
        });
        builder.show();

    }
}