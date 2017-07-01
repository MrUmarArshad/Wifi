package com.example.mruma.hackerapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


public class ShowDetail extends Activity {
    String[] processing = {"Translating Passwords", "WPS pin Saving", "Reading M1 Protocol", "Getting Mac pin ...", "AutoSaving ...", "Networks Protocol ...", "Saving IPIN ...", "Wireless Saving ...", "Cracking Pins ...", "MAC Addresses Saving ...", "Checking strength ...", "Checking Levels ...", "Checking Wifi Manager ...", "Manger Info processing ...", "Protocol Reading ...", "Consuming Passwords ...", "Manager Protocols ...", "Transfering ...", "Saving ...", "Network Saved ..."};

    int i = 0;
    Thread timer;
    private Handler handler = new Handler();
    AlertDialog.Builder builder;
    int a = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Bundle bundle = getIntent().getExtras();
        final String wifi = bundle.getString("Wifi");


        final TextView wifiDetail = (TextView) findViewById(R.id.tv_detail);

        timer = new Thread() {


            public void run() {
                try {


                    while (i < 20) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                wifiDetail.append(processing[i] + "\n");
                                wifiDetail.setMovementMethod(new ScrollingMovementMethod());

                            }
                        });
                        i = doSomeWork();
                    }


                } finally  {
                    Intent intent = new Intent(ShowDetail.this,BoxDetail.class);


                    startActivity(intent);






                    }

                }


        };
        timer.start();



//        TextView txtView = (TextView) findViewById(R.id.tv_detail);
//        Intent i = getIntent();
//        String Detail =i.getStringExtra("Detail");
//        txtView.setText(Detail);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Password");
//        builder.setMessage("Password to network:hN6Ejkh");
//        builder.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//
//                Toast.makeText(getApplicationContext(),"Copy",Toast.LENGTH_LONG).show();
//
//            }
//        });
//        builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int id) {
//                Toast.makeText(getApplicationContext(),"ok",Toast.LENGTH_LONG).show();
//            }
//        });
//
//        // Create the AlertDialog object and return it
//         builder.show();
    }












            // Create the AlertDialog object and return it






    private int doSomeWork() {
        try {

            Thread.sleep(500);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ++i;

    }

    @Override
    protected void onStop() {
        super.onStop();



    }


    protected void onResume() {

        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit ?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       finish();


                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        onDestroy();
                    }
                })
                .show();


    }




//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);
//
//        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
//        layout.addView(textView);



}
