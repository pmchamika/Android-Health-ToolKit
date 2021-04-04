package com.example.chamikaprabath.myapplication;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MedicationMain extends AppCompatActivity  {

    private Button btn;
    private Button btnDelete;
    private ListView list;
    private ArrayList<Medication> medications;
    private ArrayAdapter<Medication> adapter;





    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_main);


        list = (ListView) findViewById(R.id.medlist);
        btn = (Button) findViewById(R.id.addBtn);
        btnDelete = (Button) findViewById(R.id.delBtn);
        Button T=(Button)findViewById(R.id.delBtn);
        T.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                db.execSQL("delete from Medications");


                Toast.makeText(MedicationMain.this,"Data Deleted",Toast.LENGTH_LONG).show();
                Intent i=new Intent(getApplicationContext(),MedicationMain.class);
                startActivity(i);
            }
        });

        medications = new ArrayList<Medication>();


        adapter = new ArrayAdapter<Medication>(getApplicationContext(), android.R.layout.simple_spinner_item, medications);

        list.setAdapter(adapter);

        db = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);

        String q1 = "DROP TABLE IF EXISTS Medications";

        String query = "CREATE TABLE IF NOT EXISTS Medications (name TEXT, pillsize INTEGER, numpills INTEGER, hour INTEGER," +
                "minute INTEGER, am INTEGER)";

        String q2 = "Select * from Medications";

       // db.execSQL(q1);

        db.execSQL(query);

        Cursor c = db.rawQuery(q2, null);

        if(c.getCount() > 0){
            Log.v("Tag", "Shouldn't make it here");
            for(int i = 0; i < c.getCount(); i++){
                c.moveToPosition(i);
                String name = c.getString(0);
                int pillsize = c.getInt(1);
                int numpills = c.getInt(2);
                int hour = c.getInt(3);
                int minute = c.getInt(4);
                int am_int = c.getInt(5);
                boolean am = true;
                if(am_int==1){
                    am = false;
                }

                Medication m = new Medication(name, pillsize, numpills, hour, minute, am);
                medications.add(m);

            }
            adapter.notifyDataSetChanged();

        }



    }



    protected void addItems(View v){

        Log.v("Tag", "Made it here");

        Intent x = new Intent(this, NewMedication.class);
        startActivity(x);


    }
    public void onClickUpdate(View v){
        Intent intent = new Intent(this, MedicationUpdate.class);
        startActivity(intent);
    }
   /* protected void deleteItems(){

        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                   db.execSQL("delete from Medications");


                            Toast.makeText(MedicationMain.this,"Data Deleted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }*/













}



