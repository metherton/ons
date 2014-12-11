package com.martinetherton.ons.command.rest;

import com.martinetherton.ons.model.Country;
import com.martinetherton.ons.model.Location;
import com.martinetherton.ons.model.Surname;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 28/11/14.
 */
public class SurnameFormBuilderTest {

    @Test
    public void addSurnameFormBuilderShouldBuildForm() {
        List<Surname> surnames = new ArrayList<Surname>();
        surnames.add(new Surname());
        surnames.add(new Surname());
        Surname addedSurname = new Surname();
        SurnamesForm surnamesForm = new SurnamesForm.Builder(surnames, addedSurname).build();
        Assert.assertThat(surnamesForm.getSurnames().size(), Matchers.is(2));
        Assert.assertThat(surnamesForm.getAddedSurname(), Matchers.is(addedSurname));
    }

}
