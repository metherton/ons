package com.martinetherton.ons.command.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 12/12/14.
 */
public class Employees {

    private List<Worker> workers;
    private List<Worker> managers;

    public Employees(List<Worker> workers, List<Worker> managers) {
        this.workers = workers;
        this.managers = managers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Worker> getManagers() {
        return managers;
    }
}
