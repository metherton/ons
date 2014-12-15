package com.martinetherton.ons.command.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.Surname;

public class PersonsForm {

	public static class Builder {

		private final List<PersonDetails> personDetails;
		public Person addedPerson;
		private List<Surname> surnames;
		public List<PersonDetails> fatherDetails;
		public List<PersonDetails> motherDetails;
        public String deathDate = "1904-11-21";
        public String funeralDate = "1904-12-17";;

		
		public Builder(List<PersonDetails> personDetails, Person addedPerson, List<Surname> surnames, List<PersonDetails> fatherDetails, List<PersonDetails> motherDetails) {
			this.personDetails = personDetails;
			this.addedPerson = addedPerson;
			this.surnames = surnames;
			this.fatherDetails = fatherDetails;
			this.motherDetails = motherDetails;
		}

		public PersonsForm build() {
			return new PersonsForm(this);
		}

	}

	private List<PersonDetails> personDetails;
	private Person addedPerson;
	private List<Surname> surnames;
	private List<PersonDetails> fatherDetails;
	private List<PersonDetails> motherDetails;
    private Employees employees;

    public String getDeathDate() {
        return deathDate;
    }

    public String getFuneralDate() {
        return funeralDate;
    }

    public String deathDate;
    public String funeralDate;

	private PersonsForm(Builder builder) {
		personDetails = builder.personDetails;
		addedPerson = builder.addedPerson;
		surnames = builder.surnames;
		fatherDetails = builder.fatherDetails;
		motherDetails = builder.motherDetails;
        long oneMonthAgo = System.currentTimeMillis() - 100000;
        long oneMonthFuture = System.currentTimeMillis() + 100000;

        Date oneMonth = new Date(oneMonthAgo);
        Date oneMonthPlus = new Date(oneMonthFuture);
        Worker worker1 = new Worker("worker1", oneMonth);
        Worker worker2 = new Worker("worker2", oneMonthPlus);
        Worker manager1 = new Worker("manager1", oneMonthPlus);
        Worker manager2 = new Worker("manager2", oneMonth);
        List<Worker> workers = new ArrayList<Worker>();
        List<Worker> managers = new ArrayList<Worker>();
        workers.add(worker1);
        workers.add(worker2);
        managers.add(manager1);
        managers.add(manager2);
        employees = new Employees(workers, managers);

        deathDate = builder.deathDate;
        funeralDate = builder.funeralDate;

    }

	public List<PersonDetails> getPersonDetails() {
		return personDetails;
	}
	
	public List<PersonDetails> getFatherDetails() {
		return fatherDetails;
	}	

	public List<PersonDetails> getMotherDetails() {
		return motherDetails;
	}	
	
	public Person getAddedPerson() {
		return addedPerson;
	}

	public List<Surname> getSurnames() {
		return surnames;
	}

    public Employees getEmployees() {return employees;}


}
