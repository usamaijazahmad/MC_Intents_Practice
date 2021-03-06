package com.example.mc_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    EditText edittext;

    public static final String str="com.example.mc_app.example.str";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        edittext=findViewById(R.id.edittext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("tel:+923339448548");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("http://www.google.com/");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address="usamaijaz2001@gmail.com";
                String subject="Mobile Computing";
                Uri uri=Uri.parse("mailto:");
                Intent intent=new Intent(Intent.ACTION_SEND,uri);
                intent.setData(uri);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{address});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                if(intent.resolveActivity(getPackageManager())!=null) {
                    startActivity(intent);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                String message=edittext.getText().toString();
                intent.putExtra(str,message);
                startActivity(intent);
            }
        });
    }
}