package com.example.mahadev;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog {
    Context context;
    RadioButton USA,Spain,China,Bhutan;
    TextView text1;
    String data;
    Integer i=Integer.parseInt(data);
    public interface OnCustomListener
    {
        void onCustom();
    }
    private CustomDialog customDialog;
    public void setCustomListener(CustomDialog customDialog)
    {
        this.customDialog=customDialog;
    }

    public CustomDialog(@NonNull Context context,String data) {
        super(context);
        this.context=context;
        this.data=data;
        initViews();
        initListener();

    }
    public void initViews()
    {
        Bhutan=findViewById(R.id.Radio4);
        Spain=findViewById(R.id.Radio3);
        China=findViewById(R.id.Radio2);
        USA=findViewById(R.id.Radio1);
    }
    public void initListener()
    {
       Bhutan.setOnClickListener(new BtnBhutan());
        Spain.setOnClickListener(new BtnSpain());
        China.setOnClickListener(new BtnChina());
        USA.setOnClickListener(new BtnUSA());
    }
    class BtnBhutan implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            text1.setText(data);
        }
    }
    class  BtnUSA implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            int b=80;
            float f=i/b;
            String data1= String.valueOf(f);
            text1.setText(data1);

        }
    }
    class BtnChina implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
           int k=12;
            int in=i/k;
            String data2=String.valueOf(in);
            text1.setText(data2);

        }
    }
    class BtnSpain implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            int g=90;
            int in1=i/g;
            String data3=String.valueOf(in1);
            text1.setText(data3);

        }
    }

}
