package com.example.chamikaprabath.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MedicationUpdate extends AppCompatActivity {

    private SQLiteDatabase db;
    Button updateButton;
    EditText editMed;
    EditText editNop;
    EditText editSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_update);

        updateButton = (Button)findViewById(R.id.updateButton);
        editMed = (EditText) findViewById(R.id.editMed);
        editNop = (EditText) findViewById(R.id.editNop);
        editSize = (EditText) findViewById(R.id.editSize);
    }
    public void onClickUpdate(View v) {

        String med = editMed.getText().toString();
        String no = editNop.getText().toString();
        String size = editSize.getText().toString();


        db = openOrCreateDatabase("MyDatabase", Context.MODE_PRIVATE, null);

        String query="update Medications set pillsize='" + size + "',numpills= '" +no + "' where name='"+med+"'";
       // String query = "INSERT INTO Medications into(pillsize, numpills) VALUES ('" + editNop + "', '" +editNop + "') where name=editMed";

        db.execSQL(query);

        Intent w = new Intent(this, MedicationMain.class);
        startActivity(w);
    }
}
