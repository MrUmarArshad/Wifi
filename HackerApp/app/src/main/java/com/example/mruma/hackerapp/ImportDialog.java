package com.example.mruma.hackerapp;


import android.app.Activity;
import android.app.AlertDialog;

public class ImportDialog {
         Activity activity;
         AlertDialog dialog;
          AlertDialog.Builder builder;
           String detailProvader;

    public ImportDialog(Activity a, String detailProvader) {
        this.activity = a;
        this.detailProvader = detailProvader;
        builder = new AlertDialog.Builder(a);
    }

//    public void showDialog() {
////
////
////
////////        Intent intent = new Intent(this, DisplayMessageActivity.class);
////////        EditText editText = (EditText) findViewById(R.id.edit_message);
////////        String message = editText.getText().toString();
////////        intent.putExtra(EXTRA_MESSAGE, message);
//////        startActivity(intent);
////
//        builder.setTitle("wifi Provider Details");
//        builder.setMessage(detailProvader);
//        AlertDialog alert = builder.create();
//        alert.show();
//    }
}