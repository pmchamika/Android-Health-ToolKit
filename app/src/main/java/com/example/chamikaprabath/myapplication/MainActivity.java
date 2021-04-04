package com.example.chamikaprabath.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    public void onClickPills(View v){
        Intent intent = new Intent(this, MedicationMain.class);
        startActivity(intent);
    }
    public void onClickAppointment(View v){
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }
    public void onClickContact(View v){
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }
    public void onClickBmi(View v){
        Intent intent = new Intent(this, MainActivity_BMI.class);
        startActivity(intent);
    }
}
