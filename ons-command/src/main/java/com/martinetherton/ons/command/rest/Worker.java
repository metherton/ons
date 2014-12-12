package com.martinetherton.ons.command.rest;

import java.util.Date;

/**
 * Created by martin on 12/12/14.
 */
public class Worker extends Employee {
    private String name;
    private Date startDate;

    public Worker(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }


    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }
}
