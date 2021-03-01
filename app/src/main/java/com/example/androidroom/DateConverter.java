package com.example.androidroom;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    private static String dateFormat = "yyyy-MM-dd";

    @TypeConverter
    public String dateToString(Date fecha)
    {
        DateFormat df = new SimpleDateFormat(this.dateFormat);

        return df.format(fecha);
    }

    @TypeConverter
    public Date stringToDate(String fecha)
    {
        DateFormat df = new SimpleDateFormat(this.dateFormat);

        try {
            return df.parse(fecha);
        } catch (Exception e) {
            return new Date();
        }
    }
}
