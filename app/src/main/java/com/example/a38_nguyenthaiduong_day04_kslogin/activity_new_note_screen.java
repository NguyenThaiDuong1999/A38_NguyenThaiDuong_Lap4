package com.example.a38_nguyenthaiduong_day04_kslogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class activity_new_note_screen extends AppCompatActivity {

    Spinner sptype;
    Button btntune;
    TextView tvtime, tvdate, tvtag, tvweek;
    ArrayList<String> type;
    Calendar calendar;
    int ngay, thang, nam, gio, phut, giay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note_screen);
        setTitle("New Note Screen");

        sptype = findViewById(R.id.sptype);
        btntune = findViewById(R.id.btntune);
        tvtag = findViewById(R.id.tvtag);
        tvweek = findViewById(R.id.tvweek);
        tvtime = findViewById(R.id.tvtime);
        tvdate = findViewById(R.id.tvdate);

        calendar = calendar.getInstance();
        ngay = calendar.get(calendar.DAY_OF_MONTH);
        thang = calendar.get(calendar.MONTH);
        thang = thang + 1;
        nam = calendar.get(calendar.YEAR);
        gio = calendar.get(calendar.HOUR_OF_DAY);
        phut = calendar.get(calendar.MINUTE);
        giay = calendar.get(calendar.SECOND);

        tvtime.setText("Time: "+gio+":"+phut+":"+giay);
        tvdate.setText("Date: "+ngay+"/"+thang+"/"+nam);

        tvtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(activity_new_note_screen.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:m:s");
                        calendar.set(0, 0, 0, hourOfDay, minute);
                        tvtime.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, gio, phut, true);
                timePickerDialog.show();
            }
        });

        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(activity_new_note_screen.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        tvdate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, ngay, thang, nam);
                datePickerDialog.show();
            }
        });

        type = new ArrayList<>();
        type.add("Work");
        type.add("Entertaiment");
        type.add("Culture");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, type);
        sptype.setAdapter(arrayAdapter);

        tvtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] tag = {"FPT", "Android", "Game", "VTC"};
                final boolean[] isChecks = {false, true, false, true};

                AlertDialog alertDialog = new AlertDialog.Builder(activity_new_note_screen.this)
                        .setTitle("Select Tag")
                        .setMultiChoiceItems(tag, isChecks, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                                int position = i;
                                boolean b1 = isChecked;
                                isChecks[i] = isChecked;
                                tvtag.setText(tag[position]);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });
        tvweek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] day = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
                final boolean[] isCheck = {false, true, false, true, false, true, false};

                AlertDialog alertDialog = new AlertDialog.Builder(activity_new_note_screen.this)
                        .setTitle("Select day")
                        .setMultiChoiceItems(day, isCheck, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i, boolean isChecked) {

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {

                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        btntune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_tune, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mnfromfile:

                                break;
                            case R.id.mnfromdefault:
                                String[] tunes = {"Samsung tune", "Nokia tune", "Iphone tune", "Mi tune"};
                                AlertDialog alertDialog = new AlertDialog.Builder(activity_new_note_screen.this)
                                        .setTitle("Select tune")
                                        .setSingleChoiceItems(tunes, 1, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .create();
                                alertDialog.show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnok:
                Toast.makeText(getBaseContext(), "OK", Toast.LENGTH_LONG).show();
                break;
            case R.id.mncancel:

                break;
            case R.id.mnsave:
                Toast.makeText(getBaseContext(), "Save", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
