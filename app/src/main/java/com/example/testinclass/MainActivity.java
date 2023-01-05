package com.example.testinclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    public int i=0;
    employee [] emp= new employee[1];
    private EditText edt1;
    private EditText edt2;
    //private ListView view;
    public String ee;
    public String ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1= findViewById(R.id.edtText1);
        edt2= findViewById(R.id.edtText2);
        //Spinner spinner = (Spinner) findViewById(R.id.spinner);
    }

    public void btn1OnClick(View view) {
         ee= edt1.getText().toString();
         ss= edt2.getText().toString();
        emp[0] = new employee(ee,ss);
        //i++;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String employeeString = gson.toJson(emp);

        editor.putString("12", employeeString);
        editor.commit();
        //view.setText("name"+ ee + " "+ "salary:" + ss);
        
        Toast.makeText(this, "name + salary =" + ee+" "+ss
                , Toast.LENGTH_SHORT).show();
    }
    
}