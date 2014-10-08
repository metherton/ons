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
        Person father = new Person();
        father.setFirstName("Sid");
        Person mother = new Person();
        mother.setFirstName("Nora");
        person.setFather(father);
        person.setMother(mother);
        assertThat(person.getBirthDate(), Matchers.is(myBirthDate));
        assertThat(person.getFather().getFirstName(), Matchers.is("Sid"));
        assertThat(person.getMother().getFirstName(), Matchers.is("Nora"));        
    }
    
}
