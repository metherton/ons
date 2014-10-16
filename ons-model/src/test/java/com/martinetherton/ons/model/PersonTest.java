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
        Father father = new Father();
        father.setEntityId(1L);
        Mother mother = new Mother();
        mother.setEntityId(1L);
        person.setFather(father);
        person.setMother(mother);
        assertThat(person.getBirthDate(), Matchers.is(myBirthDate));
        assertThat(person.getFather().getEntityId(), Matchers.is(1L));
        assertThat(person.getMother().getEntityId(), Matchers.is(1L));        
    }
    
}
