package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class BorrowBook extends AppCompatActivity{

    private  Button btnChooseDate;
    private TextView mSelectedDates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_book);

        btnChooseDate = findViewById((R.id.btn_choose_date));
        mSelectedDates = findViewById(R.id.selected_dates);

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();


        MaterialDatePicker.Builder<Pair<Long, Long>> builder  = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("Choose A Date : ");

        final MaterialDatePicker<Pair<Long, Long>> materialDatePicker = builder.build();

        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                Pair selectedDates = (Pair) materialDatePicker.getSelection();
                final Pair<Date, Date> rangeDate = new Pair<>(new Date((Long) selectedDates.first), new Date((Long) selectedDates.second));
                Date startDate = rangeDate.first;
                Date endDate = rangeDate.second;
                SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
                mSelectedDates.setText("Selected Dates:\n \n" +  simpleFormat.format(startDate) + " - " + simpleFormat.format(endDate));
            }




        });
    }



}