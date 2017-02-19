package com.samurais.codeninjas.taskmanager;
/**
 * Created by Drsk8 on 2/18/2017.
 */

public class Date{
   //Formatting the date into minutes and hours
    public String getMethTime(){
        int x = 0;
        //if the time is longer than 1 hour
        //if the time is longer than a day
        if(x > 60) {
            if (x / 60 >= 24) {
                //Calculate the time into days and return
                return (x / 60) / 24 + " days";
            } else {
                //x is less than a 1 hour and can remain in minutes and return the minutes
                return x + " hrs";

            }
        }
        //return minutes
        return x + "min";

    }
}
