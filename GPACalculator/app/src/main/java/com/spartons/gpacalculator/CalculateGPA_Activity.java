package com.spartons.gpacalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class CalculateGPA_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private CharSequence gradeName,creditHour;
    private Button firstSubjectGradesButton,secondSubjectGradesButton,thirdSubjectGradesButton,fourthSubjectGradesButton,
            fifthSubjectGradesButton,sixthSubjectGradesButton;
    private Button firstSubjectCreditButton,secondSubjectCreditButton,thirdSubjectCreditButton,fourthSubjectCreditButton,
            fifthSubjectCreditButton,sixthSubjectCreditButton;
    private EditText firstSubjectEditText,secondSubjectEditText,thirdSubjectEditText,fourthSubjectEditText,
            fifthSubjectEditText,sixthSubjectEditText;
    private TextView creditsHourTextView,gpaTextView;
    private CharSequence creditsHour;
    private String creditsHourAgain;
    private String gpaText;
    private LinkedList<Double> creditHourList=new LinkedList<>();
    private LinkedList<Double> gradesList=new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_gpa_);
        Intent intent=getIntent();
        String buttonNumber=intent.getStringExtra("buttonNumber");
        int number=Integer.valueOf(buttonNumber);
        number--;
        spinner= (Spinner) findViewById(R.id.semesterSpinner);
        spinner.setOnItemSelectedListener(this);
        firstSubjectGradesButton= (Button) findViewById(R.id.firstSubjectGradesButton);
        secondSubjectGradesButton= (Button) findViewById(R.id.secondSubjectGradesButton);
        thirdSubjectGradesButton= (Button) findViewById(R.id.thirdSubjectGradesButton);
        fourthSubjectGradesButton= (Button) findViewById(R.id.fourthSubjectGradesButton);
        fifthSubjectGradesButton= (Button) findViewById(R.id.fifthSubjectGradesButton);
        sixthSubjectGradesButton= (Button) findViewById(R.id.sixthSubjectGradesButton);
        firstSubjectCreditButton= (Button) findViewById(R.id.firstSubjectCreditButton);
        secondSubjectCreditButton= (Button) findViewById(R.id.secondSubjectCreditButton);
        thirdSubjectCreditButton= (Button) findViewById(R.id.thirdSubjectCreditButton);
        fourthSubjectCreditButton= (Button) findViewById(R.id.fourthSubjectCreditButton);
        fifthSubjectCreditButton= (Button) findViewById(R.id.fifthSubjectCreditButton);
        sixthSubjectCreditButton= (Button) findViewById(R.id.sixthSubjectCreditButton);
        firstSubjectEditText= (EditText) findViewById(R.id.firstSubjectEditText);
        secondSubjectEditText= (EditText) findViewById(R.id.secondSubjectEditText);
        thirdSubjectEditText= (EditText) findViewById(R.id.thirdSubjectEditText);
        fourthSubjectEditText= (EditText) findViewById(R.id.fourthSubjectEditText);
        fifthSubjectEditText= (EditText) findViewById(R.id.fifthSubjectEditText);
        sixthSubjectEditText= (EditText) findViewById(R.id.sixthSubjectEditText);
        creditsHourTextView= (TextView) findViewById(R.id.creditsHourTextView);
        gpaTextView= (TextView) findViewById(R.id.gpaTextView);
        ArrayAdapter<CharSequence> semesterAdapter=ArrayAdapter.createFromResource(this,R.array.semesterNames,R.layout.spinner);
        semesterAdapter.setDropDownViewResource(R.layout.spinner);
        spinner.setAdapter(semesterAdapter);
        spinner.setSelection(number,true);
    }

    public void firstSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(firstSubjectGradesButton);
    }

    public void secondSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(secondSubjectGradesButton);
    }

    public void thirdSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(thirdSubjectGradesButton);
    }

    public void fourthSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(fourthSubjectGradesButton);
    }

    public void fifthSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(fifthSubjectGradesButton);
    }

    public void sixthSubjectGradesButtonClicked(View view){
        showGradesDialogFragment(sixthSubjectGradesButton);
    }

    public void firstSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(firstSubjectCreditButton);
    }

    public void secondSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(secondSubjectCreditButton);
    }

    public void thirdSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(thirdSubjectCreditButton);
    }

    public void fourthSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(fourthSubjectCreditButton);
    }

    public void fifthSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(fifthSubjectCreditButton);
    }

    public void sixthSubjectCreditButtonClicked(View view){
        showCreditsDialogButton(sixthSubjectCreditButton);
    }

    public void clearSemesterButtonClicked(View view){
        clearAllViews();
    }

    private void clearAllViews() {
        firstSubjectCreditButton.setText("Cr");
        firstSubjectGradesButton.setText("Gr");
        secondSubjectCreditButton.setText("Cr");
        secondSubjectGradesButton.setText("Gr");
        thirdSubjectCreditButton.setText("Cr");
        thirdSubjectGradesButton.setText("Gr");
        fourthSubjectCreditButton.setText("Cr");
        fourthSubjectGradesButton.setText("Gr");
        fifthSubjectCreditButton.setText("Cr");
        fifthSubjectGradesButton.setText("Gr");
        sixthSubjectCreditButton.setText("Cr");
        sixthSubjectGradesButton.setText("Gr");
        firstSubjectEditText.setText("");
        secondSubjectEditText.setText("");
        thirdSubjectEditText.setText("");
        fourthSubjectEditText.setText("");
        fifthSubjectEditText.setText("");
        sixthSubjectEditText.setText("");
        creditsHourTextView.setText("0");
        gpaTextView.setText("0");
        gradesList.clear();
        creditHourList.clear();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void showGradesDialogFragment(final Button button){
        RelativeLayout layout= (RelativeLayout) button.getParent();
        final Button button1= (Button) layout.getChildAt(1);
        Log.e("showGradesDialogFragmen",button1.getText().toString());
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this,R.style.AppCompatAlertDialogStyle);
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Select Grades");
        alertDialog.setItems(getResources().getTextArray(R.array.grades), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CharSequence gradesArray[] = getResources().getTextArray(R.array.grades);
                String grade = null;
                String GPA = null;
                for (int j = 0; j < gradesArray.length; j++) {
                    if (j == i) {
                        gradeName = gradesArray[j];
                        GPA = gradeName.toString().substring(gradeName.toString().indexOf("(")).replace("(", "").replace(")", "");
                        grade = gradeName.toString().substring(0, gradeName.toString().indexOf("("));
                        gradesList.add(Double.valueOf(GPA));
                    }
                }
                if(!button1.getText().toString().equals("Cr")){
                    setGpaText();
                }else{

                }
                dialogInterface.dismiss();
                button.setText(grade);
            }
        });
        final AlertDialog  dialog=alertDialog.create();
        dialog.show();
    }

    private void showCreditsDialogButton(final Button button){
        RelativeLayout layout= (RelativeLayout) button.getParent();
        final Button button1= (Button) layout.getChildAt(0);
        Log.e("showGradesDialogFragmen",button1.getText().toString());
        final AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.AppCompatAlertDialogStyle);
        builder.setCancelable(false);
        builder.setTitle("Select Credit Hours");
        builder.setItems(getResources().getTextArray(R.array.credits_hour), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CharSequence credits_hors_array[] = getResources().getTextArray(R.array.credits_hour);
                for (int j = 0; j < credits_hors_array.length; j++) {
                    if (i == j) {
                        creditHour = credits_hors_array[j];
                        creditHourList.add(Double.valueOf(String.valueOf(creditHour)));
                    }
                }
                dialogInterface.dismiss();
                if (button.getText().toString().equals("Cr")) {
                    setCreditsHour(creditHour);
                    button.setText(creditHour);
                    if(!button1.getText().toString().equals("Gr")){
                        setGpaText();
                    }else{
                        Log.e( "AfterTime", button1.getText().toString());
                    }
                } else {
                    int credit = Integer.valueOf(button.getText().toString());
                    button.setText(creditHour);
                    int credit2 = Integer.valueOf(button.getText().toString());
                    String s = String.valueOf(credit2 - credit);
                    setCreditsHour(s);
                    if(!button1.getText().toString().equals("Gr")){
                        setGpaText();
                    }else{
                        Log.e( "AfterTime", button1.getText().toString());
                    }
                }
            }
        });
        final AlertDialog dialog=builder.create();
        dialog.show();
    }

    public void setCreditsHour(CharSequence creditsHour) {
        int creditHours=Integer.valueOf(creditsHourTextView.getText().toString());
        int totalCreditHour=creditHours+Integer.valueOf(String.valueOf(creditsHour));
        creditsHourTextView.setText(String.valueOf(totalCreditHour));
    }

    public void setGpaText() {
        if(creditHourList.size()!=gradesList.size()){
            Toast.makeText(this,"Please enter both fields",Toast.LENGTH_SHORT).show();
        }
        else {
            double total = 0;
            double totalCreditHour = 0;
            for (Double hourList : creditHourList) {
                totalCreditHour += hourList;
            }

            for (int i = 0; i < creditHourList.size(); i++) {
                double v = creditHourList.get(i);
                Log.e("setGpaText: ", v + "");
                double v1 = gradesList.get(i);
                Log.e("setGpaText: ", v1 + "");
                total = v * v1 + total;
            }
            double v = total / totalCreditHour;
            Log.e("CreditHours", totalCreditHour + "");
            Log.e("toatl", total + "");
            Log.e("setGpaText:", String.valueOf(v));
            gpaTextView.setText(String.valueOf(new DecimalFormat("##.##").format(total/totalCreditHour)));

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        MainActivity.flag=true;
        intent.putExtra("GPA",gpaTextView.getText().toString());
        startActivity(intent);
    }
}
