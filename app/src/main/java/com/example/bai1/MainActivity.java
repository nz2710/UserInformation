package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    AlertDialog.Builder builder;
    private TextView dateText;
    private TextView firstName;
    private TextView lastName;
    private RadioButton male;
    private RadioButton female;
    private TextView address;
    private TextView email;
    private CheckBox termAgree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateText=findViewById(R.id.birthday);
        firstName=findViewById(R.id.editTextFirstName);
        lastName=findViewById(R.id.lastNameEditText);
        male=findViewById(R.id.maleButton);
        female=findViewById(R.id.femleButton);
        address=findViewById(R.id.addressEditText);
        email=findViewById(R.id.emailEditText);
        termAgree=findViewById(R.id.termAgreeCheckBox);



    }

    public void selectBirthday(View view) {
        showDatePickerDialog();
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String date =year+"/"+month+"/"+day;
        dateText.setText(date);
    }

    public void registerAction(View view) {


        String textCheck="Chưa Tích chọn: \n";
        String text="Chưa nhập: \n";
        if(firstName.getText().equals("")){
            text+="FirstName \n";
        }
        if(lastName.getText().equals("")){
            text+="LastName \n";
        }
        if((male.isChecked()==false)&&(female.isChecked()==false)){
            textCheck+="Gender \n";
        }
        if(dateText.getText().equals("")){
            text+="Birthday \n";
        }
        if(address.getText().equals("")){
            text+="Address \n";
        }
        if(email.getText().equals("")){
            text+="Email \n";
        }
        if(!termAgree.isChecked()){
            textCheck+="TermAgree\n";
        }

        if((textCheck.equals("Chưa Tích chọn: \n"))&&(text.equals("Chưa nhập: \n"))){
            String successText="Success";
            showMessage(successText);
            male.setClickable(true);
            female.setClickable(true);
            male.setChecked(false);
            female.setChecked(false);
            termAgree.setChecked(false);
            firstName.setText("");
            lastName.setText("");
            dateText.setText("");
            address.setText("");
            email.setText("");

        }else {
            showMessage(text + textCheck);
        }


    }
    public void showMessage(String text){
        builder= new AlertDialog.Builder(this);
        builder.setTitle("Message").setMessage(text).setCancelable(true).setPositiveButton("ok",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }

    public void maleButton(View view) {
        female.setClickable(false);
    }

    public void femaleButton(View view) {
        male.setClickable(false);
    }
}