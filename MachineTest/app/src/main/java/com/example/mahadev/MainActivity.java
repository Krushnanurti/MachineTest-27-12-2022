package com.example.mahadev;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText Username,Password,PhoneNumber;
Button Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        
    }
    public void initViews()
    {
        Username=findViewById(R.id.Username);
        Password=findViewById(R.id.Password);
        PhoneNumber=findViewById(R.id.PhoneNumber);
        Next=findViewById(R.id.ButtonToNextActivity);
        Next.setOnClickListener(new ListenerNext());
    }
    class ListenerNext implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            if (Username.getText().toString().equals("krishna") && Password.getText().toString().equals("krishna")) {
                Intent intent = new Intent(MainActivity.this, CurrencyConvertionActivity.class);
                intent.putExtra("Name", Username.getText().toString());
                intent.putExtra("Pass", Password.getText().toString());
                intent.putExtra("Number", PhoneNumber.getText().toString());
                startActivity(intent);
            }
            else
            {
                Toast.makeText(MainActivity.this,"Please enter correct data",Toast.LENGTH_LONG).show();
            }
        }
    }
}