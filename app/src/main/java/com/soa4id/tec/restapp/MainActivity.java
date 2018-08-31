package com.soa4id.tec.restapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import data.DBHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper mDbHelper = new DBHelper(MainActivity.this);
        mDbHelper.addUserCredentials("Juan","Navarro","jnavcamacho@gmail.com","password",1);
        mDbHelper.addUserCredentials("Esteban","Camacho","navarroesteban2009@hotmail.com","password",2);

    }


}
