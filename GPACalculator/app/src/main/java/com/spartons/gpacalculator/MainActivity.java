package com.spartons.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button semesterOneButton,semesterTwoButton,semesterThreeButton,semesterFourButton,semesterFiveButton,
            semesterSixButton,semesterSevenButton,semesterEightButton,semesterNineButton,clearAllDataButton,semesterTenButton;
    private TextView mainCGPATextView;
    public static boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        semesterOneButton= (Button) findViewById(R.id.semesterOneButton);
        semesterTwoButton=(Button) findViewById(R.id.semesterTwoButton);
        semesterThreeButton= (Button) findViewById(R.id.semesterThreeButton);
        semesterFourButton= (Button) findViewById(R.id.semesterFourButton);
        semesterFiveButton= (Button) findViewById(R.id.semesterFiveButton);
        semesterSixButton= (Button) findViewById(R.id.semesterSixButton);
        semesterSevenButton= (Button) findViewById(R.id.semesterSevenButton);
        semesterEightButton= (Button) findViewById(R.id.semesterEightButton);
        semesterNineButton= (Button) findViewById(R.id.semesterNineButton);
        clearAllDataButton= (Button) findViewById(R.id.clearAllDataButton);
        semesterTenButton= (Button) findViewById(R.id.semesterTenButton);
        mainCGPATextView= (TextView) findViewById(R.id.mainCGPATextView);
        clearAllDataButton= (Button) findViewById(R.id.clearAllDataButton);

        if(flag) {
            Intent intent = getIntent();
            String s = intent.getStringExtra("GPA");
            mainCGPATextView.setText(s);
            flag=false;
        }
    }

    public void semesterOneButtonClicked(View view){
        sendIntents("1");
    }

    public void semesterTwoButtonClicked(View view){
        sendIntents("2");
    }

    public void semesterThreeButtonClicked(View view){
        sendIntents("3");
    }

    public void semesterFourButtonClicked(View view){
        sendIntents("4");
    }

    public void semesterFiveButtonClicked(View view){
        sendIntents("5");
    }

    public void semesterSixButtonClicked(View view){
        sendIntents("6");
    }

    public void semesterSevenButtonClicked(View view){
        sendIntents("7");
    }

    public void semesterEightButtonClicked(View view){
        sendIntents("8");
    }

    public void semesterNineButtonClicked(View view){
        sendIntents("9");
    }

    public void semesterTenButtonClicked(View view){
        sendIntents("10");
    }

    public void clearAllDataButtonClicked(View view){
        Toast toast=Toast.makeText(this,"All data is cleared",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private void sendIntents(String buttonNumber){
        Intent intent=new Intent(this,CalculateGPA_Activity.class);
        intent.putExtra("buttonNumber",buttonNumber);
        startActivity(intent);
    }
}
