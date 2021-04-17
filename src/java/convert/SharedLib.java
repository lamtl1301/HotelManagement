/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class SharedLib {

    public static String converDateToString(Date time) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String stringDate = formatter.format(time);
        return stringDate;
    }

    public static Date convertStringToDate(String time) {
        Date timeofCreate = null;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        try {
            timeofCreate = format.parse(time);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return timeofCreate;
    }

    public static int numOfDays(Date checkin, Date checkout) {
        long diff = checkout.getTime() - checkin.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        int i = (int) diffDays ;
        return i;
    }
    public static String currentDay(){
        String date = "";
        Date day = new Date();
        date =converDateToString(day);
        return date;
    }
    public static String nextDay(){
        String date = "";
        Calendar l = Calendar.getInstance();
        l.add(Calendar.DAY_OF_YEAR, 1);
        date =converDateToString(l.getTime());
        return date;
    }

}
