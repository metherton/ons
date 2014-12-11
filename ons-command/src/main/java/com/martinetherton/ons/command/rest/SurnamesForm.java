package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Surname;

import java.util.List;

/**
 * Created by martin on 28/11/14.
 */
public class SurnamesForm {
    private final List<Surname> surnames;
    private final Surname addedSurname;

    public SurnamesForm(Builder builder) {
        this.surnames = builder.surnames;
        this.addedSurname = builder.addedSurname;
    }

    public List<Surname> getSurnames() {
        return surnames;
    }

    public Surname getAddedSurname() {
        return addedSurname;
    }

    public static class Builder {
        public List<Surname> surnames;
        public Surname addedSurname;

        public Builder(List<Surname> surnames, Surname addedSurname) {
            this.surnames = surnames;
            this.addedSurname = addedSurname;
        }

        public SurnamesForm build() {
            return new SurnamesForm(this);
        }
    }
}
