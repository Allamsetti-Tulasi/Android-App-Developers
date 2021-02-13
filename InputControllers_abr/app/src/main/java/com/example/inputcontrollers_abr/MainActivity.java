package com.example.inputcontrollers_abr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    /*RadioGroup  is used to group together  one or more buttons
    * Radio Button has two states either checked or unchecked
    * CheckBox When presenting  users with a group of  selectable options
    * that are not mutually exclusive
    * Switch used to display checked or unchecked state of  a  button
    * providing slider controller to user.
    * Spinner is a Dropdown list that allows users to select one value from
    * a list*/
    RadioGroup radio1;
    RadioButton radiob1,radiob2;
    CheckBox check1,check2,check3;
    Switch aSwitch;
    LinearLayout linearLayout;
    Spinner spinner;
    DatePicker datePicker;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time1);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(MainActivity.this, i+":"+i1,
                        Toast.LENGTH_SHORT).show();
            }
        });
        datePicker = findViewById(R.id.datepicker1);
        radio1 = findViewById(R.id.rg1);
        radiob1 = findViewById(R.id.rb1);
        radiob2 = findViewById(R.id.rb2);
        check1 = findViewById(R.id.ch1);
        check2 = findViewById(R.id.ch2);
        check3 = findViewById(R.id.ch3);
        aSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.linear1);
        spinner = findViewById(R.id.spinner1);

        ArrayList weaks = new ArrayList<>();
        weaks.add("SunDay");
        weaks.add("Monday");
        weaks.add("TuseDay");
        weaks.add("WednesDay");
        weaks.add("ThursDay");
        weaks.add("Friday");
        weaks.add("Saturday");
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker,
                                              int year, int monthofYear,
                                              int dayofMonth) {
                       monthofYear = monthofYear+1;
                       String date = dayofMonth +"-"+ monthofYear+"-"+year;
                        Toast.makeText(MainActivity.this, date, Toast.LENGTH_SHORT).show();
                    }
                });
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,weaks);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Selected"+weaks.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }) ;


        radio1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this, "Male",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this, "FeMale",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    public void img(View view) {
        Toast.makeText(this, "Hai Students",
                Toast.LENGTH_SHORT).show();
    }

    public void submit(View view) {
        if(check1.isChecked()&&check2.isChecked()&&check3.isChecked()){
            Toast.makeText(this, ""+check1.getText()+
                    "\n"+check2.getText()+"\n"+check3.getText(),
                    Toast.LENGTH_SHORT).show();
        }else if(check1.isChecked()&&check2.isChecked()){
            Toast.makeText(this, ""+check1.getText()+"\n"+check2.getText(),
                    Toast.LENGTH_SHORT).show();
        }else if (check2.isChecked()&&check3.isChecked()){
            Toast.makeText(this, ""+check2.getText()+"\n"+check3.getText(),
                    Toast.LENGTH_SHORT).show();

        }else if (check1.isChecked()&&check3.isChecked()){
            Toast.makeText(this, ""+check1.getText()+"\n"+check3.getText(),
                    Toast.LENGTH_SHORT).show();

        }else if (check1.isChecked()){
            Toast.makeText(this, ""+check1.getText(), Toast.LENGTH_SHORT).show();
        }
        else if (check2.isChecked()){
            Toast.makeText(this, ""+check2.getText(), Toast.LENGTH_SHORT).show();
        }
        else if (check3.isChecked()){
            Toast.makeText(this, ""+check3.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void changeColor(View view) {
        if(aSwitch.isChecked()){
            linearLayout.setBackgroundColor(Color.GREEN);
        }else{
            linearLayout.setBackgroundColor(Color.RED);
        }

    }
}