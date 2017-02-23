package com.adil.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by adil on 2/21/2017.
 */

 public class QuakeList {
    private String cityName;
    private long date;
    private double magnitude;
    private String url;


    public QuakeList(double magnitude, String cityName, long date,String url) {
        this.cityName = cityName;
        this.date = date;
        this.magnitude = magnitude;
        this.url=url;
    }


    public String getUrl()
    {return url;}

    public String getCityName() {
        return cityName;
    }

    public String getDate() {
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD,yyyy");
        String datetodisplay = dateFormat.format(dateObject);
        return datetodisplay;
    }

    public String getSubDate() {
        Date dateObject = new Date(date);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
        String datetodisplay1 = dateFormat1.format(dateObject);
        return datetodisplay1;
    }

   double getMagnitude() {

        return magnitude;
    }


}
