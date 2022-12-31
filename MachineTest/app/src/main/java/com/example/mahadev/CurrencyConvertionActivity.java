package com.example.mahadev;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConvertionActivity extends AppCompatActivity {
    TextView UN,Phone;
    EditText EnterAmount;
    Button DatePicker,TimePicker,Convert,ColorPicker;
    String User,number;
    Resources resources;
    String[] color;
    private final int LogOut=1,LogIn=2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_convertion_activity);
        initViews();
        initListener();
        extras();
        resources=getResources();
        color=resources.getStringArray(R.array.colors);


    }
    public void extras()
    {
        Intent i=getIntent();
        Bundle bundle=i.getExtras();
        User=bundle.getString("Name");
        number= bundle.getString("Number");
        UN.setText(User);
        Phone.setText(number);
    }

    public void initViews()
    {
        UN=findViewById(R.id.TextView1);
        Phone=findViewById(R.id.TexView2);
        DatePicker=findViewById(R.id.DatePicker);
        TimePicker=findViewById(R.id.TimePicker);
        EnterAmount=findViewById(R.id.Paise);
        Convert=findViewById(R.id.Convert);
        ColorPicker=findViewById(R.id.ColorPicker);



    }
    public void initListener()
    {
        Convert.setOnClickListener(new BtnConvert());
        DatePicker.setOnClickListener(new BtnDatePicker());
        TimePicker.setOnClickListener(new TimePickerClass());
        ColorPicker.setOnClickListener(new BtnColorPicker());
    }
    class BtnColorPicker implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            CustomDialogForColorPicker customDialogForColorPicker=new CustomDialogForColorPicker(
                    CurrencyConvertionActivity.this,1,color
            );

        }
    }

    class BtnConvert implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
           CustomDialog customDialog=new CustomDialog(CurrencyConvertionActivity.this,
                   EnterAmount.getText().toString());
           customDialog.show();

        }

    }
    class BtnDatePicker implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            DatePickerDialog datePickerDialog=new DatePickerDialog(CurrencyConvertionActivity.this,
                    new DatePickerClass(),2022,10,12 );
            datePickerDialog.show();

        }
    }
    class TimePickerClass implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            TimePickerDialog timePickerDialog=new TimePickerDialog(CurrencyConvertionActivity.this,
                    new BtnTimePicker(),12,12,false);
            timePickerDialog.show();
        }
    }
    class DatePickerClass implements DatePickerDialog.OnDateSetListener
    {

        @Override
        public void onDateSet(android.widget.DatePicker datePicker, int Year, int Month, int Day) {
            DatePicker.setText( + Year + "/" + "/" + Day);
        }
    }
    class BtnTimePicker implements TimePickerDialog.OnTimeSetListener
    {

        @Override
        public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {
            TimePicker.setText(i + "/" + i1);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuItem menuItem=menu.add(1,1,1,"LogOut");
       MenuItem menuItem1=menu.add(2,2,2,"LogIn");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==1)
        {
            Toast.makeText(CurrencyConvertionActivity.this,
                    "LogOut Successful",Toast.LENGTH_LONG).show();
        }
        if (item.getItemId()==2)
        {
            Toast.makeText(CurrencyConvertionActivity.this,
                    "LogIn Successful",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
