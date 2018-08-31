package com.soa4id.tec.restapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
    private RadioButton mRoleStudent;
    private RadioButton mRoleAdmin;
    private EditText mCareer;
    private EditText mLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRoleStudent = findViewById(R.id.register_activity_user_role_student);
        mRoleAdmin = findViewById(R.id.register_activity_user_role_admin);

        mCareer = findViewById(R.id.register_activity_student_career);
        mLicense = findViewById(R.id.register_activity_student_license);

        mRoleStudent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mCareer.setEnabled(true);
                    mLicense.setEnabled(true);
                }
            }
        });
        mRoleAdmin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mCareer.setEnabled(false);
                    mLicense.setEnabled(false);
                }
            }
        });
    }
}
