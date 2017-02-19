package com.samurais.codeninjas.taskmanager;

/**
 * Created by Derek on 2/18/2017.
 */

public class Task {
    private String name;
    private String subject;
    private String details;
    private double duration;
    private Date dueDate;

    public Task(String n,String sub,String deets, double dur, Date due){
        name = n;
        subject = sub;
        details = deets;
        duration = dur;
        dueDate = due;
    }

    public String getName(){
        return name;
    }

    public String getSubject(){
        return subject;
    }

    public String getDetails(){
        return details;
    }

    public double getDuration(){
        return duration;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
