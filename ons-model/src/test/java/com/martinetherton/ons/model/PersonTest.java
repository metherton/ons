package com.martinetherton.ons.model;



import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PersonTest {

    @Test
    public void personGettersAndSetters() {
        Person person = new Person();
        Calendar cal = Calendar.getInstance();
        cal.set(1963, 3, 4);
        Date myBirthDate = cal.getTime();
        person.setBirthDate(myBirthDate);
        assertThat(person.getBirthDate(), Matchers.is(myBirthDate));
    }
    
}
