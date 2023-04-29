package ir.shariaty.persiancalender;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.api.PersianPickerDate;
import ir.hamsaa.persiandatepicker.api.PersianPickerListener;
import ir.hamsaa.persiandatepicker.util.PersianCalendarUtils;

public class MainActivity extends AppCompatActivity {
Button butoon_show;
TextView textview_date;
String selected_date="";
PersianDatePickerDialog picker;
String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butoon_show=findViewById(R.id.show_button);

        getSupportActionBar().hide();

        butoon_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker=new PersianDatePickerDialog(MainActivity.this)
                        .setPositiveButtonString("باشه")
                        .setNegativeButton("بیخیال")
                        .setTodayButton("امروز")
                        .setTodayButtonVisible(true)
                        .setMinYear(1300)
                        .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                        .setMaxMonth(12)
                        .setMaxDay(PersianDatePickerDialog.THIS_DAY)
                        .setInitDate(1382,2,18)
                        .setActionTextColor(Color.WHITE)
                        .setPickerBackgroundColor(Color.YELLOW)
                        .setBackgroundColor(Color.BLACK)
                        .setTitleColor(Color.WHITE)
                        .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                        .setShowInBottomSheet(true)
                        .setListener(new PersianPickerListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSelected(@NotNull PersianPickerDate persianPickerDate) {
                                Log.d(TAG, "onDateSelected: " + persianPickerDate.getTimestamp());
                                Log.d(TAG, "onDateSelected: " + persianPickerDate.getGregorianDate());
                                Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianLongDate());
                                Log.d(TAG, "onDateSelected: " + persianPickerDate.getPersianMonthName());
                                Log.d(TAG, "onDateSelected: " + PersianCalendarUtils.isPersianLeapYear(persianPickerDate.getPersianYear()));
                                Toast.makeText(MainActivity.this,persianPickerDate.getPersianYear()+"/"+persianPickerDate.getPersianMonth()+"/"+persianPickerDate.getPersianDay(),Toast.LENGTH_SHORT).show();
                                selected_date=((persianPickerDate.getPersianYear()+"/"+persianPickerDate.getPersianMonth()+"/"+persianPickerDate.getPersianDay()));
                                textview_date.setText(selected_date);
                            }

                            @Override
                            public void onDismissed() {

                            }
                        });

                picker.show();
            }
        });


    }
}