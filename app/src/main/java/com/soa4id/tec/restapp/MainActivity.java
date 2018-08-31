package com.soa4id.tec.restapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import data.DBHelper;

public class MainActivity extends AppCompatActivity {
    public Button loginBtn;
    public Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper mDbHelper = new DBHelper(MainActivity.this);
        mDbHelper.addUserCredentials("Juan","Navarro","jnavcamacho@gmail.com","password",1);
        mDbHelper.addUserCredentials("Esteban","Camacho","navarroesteban2009@hotmail.com","password",2);
        mDbHelper.checkUserCredentials("jnavcamacho@gmail.com","password");
        mDbHelper.checkUserCredentials("jnavcamacho@gmail.com","password1");
        mDbHelper.checkUserCredentials("navarroesteban2009@hotmail.com","password");

        loginBtn = findViewById(R.id.main_activity_login_button);
        registerBtn = findViewById(R.id.main_activity_register_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


}
