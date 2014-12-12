package com.martinetherton.ons.command.rest;

/**
 * Created by martin on 12/12/14.
 */
public class Manager extends Employee {

    private String name;

    public Manager(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
