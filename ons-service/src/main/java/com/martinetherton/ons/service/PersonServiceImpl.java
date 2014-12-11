package com.martinetherton.ons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.ons.model.Marriage;
import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.PersonDetails;
import com.martinetherton.ons.model.SearchResult;
import com.martinetherton.ons.model.SearchResultFactory;
import com.martinetherton.ons.persist.MarriageRepository;
import com.martinetherton.ons.persist.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    private MarriageRepository marriageRepository;
    private PersonVisitCount personVisitCount;

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

//    @Autowired
//    public void setPersonVisitCount(PersonVisitCount personVisitCount) {
//        this.personVisitCount = personVisitCount;
//    }

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, MarriageRepository marriageRepository, PersonVisitCount personVisitCount) {
        this.personRepository = personRepository;
        this.marriageRepository = marriageRepository;
        this.personVisitCount = personVisitCount;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Person getPerson(long id) {
        personVisitCount.incrementCount();
        return personRepository.findBy(id);
    }

    @Override
    @Transactional
    public Person addPerson(Person pToInsert) {

        return personRepository.add(pToInsert);
    }

    @Override
    public void pointcut1() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pointcut2() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pointcutWithParam(String name) {
        System.out.println("pointcutWithParam: " + name);
    }

	@Override
	@Transactional(readOnly=true)
	public List<PersonDetails> listAllPersonDetails() {
		List<Person> persons = personRepository.findAll();
		List<PersonDetails> listPersonDetails = new ArrayList<PersonDetails>();
		for (Person p : persons) {
			List<Marriage> retrievedMarriages = marriageRepository.findMarriagesFor(p);
			Person mother = (p.getMotherId() != null) ? personRepository.findBy(p.getMotherId()) : null;
			Person father = (p.getFatherId() != null) ? personRepository.findBy(p.getFatherId()) : null;
			PersonDetails personDetails = new PersonDetails.Builder(p)
												.withMarriages(retrievedMarriages)
												.withMother(mother)
												.withFather(father)
												.build();
			listPersonDetails.add(personDetails);
		}
		return listPersonDetails;
	}

	@Override
    @Transactional(readOnly=true)
	public PersonDetails getPersonDetails(long id) {
		Person retrievedPerson = personRepository.findBy(id);
		Person mother = (retrievedPerson.getMotherId() != null) ? personRepository.findBy(retrievedPerson.getMotherId()) : null;
		Person father = (retrievedPerson.getFatherId() != null) ? personRepository.findBy(retrievedPerson.getFatherId()) : null;
		List<Marriage> retrievedMarriages = marriageRepository.findMarriagesFor(retrievedPerson);
		return new PersonDetails.Builder(retrievedPerson)
								.withMarriages(retrievedMarriages)
								.withMother(mother)	
								.withFather(father).build();
	}

	@Override
	@Transactional(readOnly=true)
	public List<PersonDetails> listAllMalePersonDetails() {
		List<Person> persons = personRepository.findAllMalePersons();
		List<PersonDetails> listPersonDetails = new ArrayList<PersonDetails>();
		for (Person p : persons) {
			Person mother = (p.getMotherId() != null) ? personRepository.findBy(p.getMotherId()) : null;
			Person father = (p.getFatherId() != null) ? personRepository.findBy(p.getFatherId()) : null;
			PersonDetails personDetails = new PersonDetails.Builder(p)
												.withMother(mother)
												.withFather(father)
												.build();
			listPersonDetails.add(personDetails);
		}
		return listPersonDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<PersonDetails> listAllFemalePersonDetails() {
		List<Person> persons = personRepository.findAllFemalePersons();
		List<PersonDetails> listPersonDetails = new ArrayList<PersonDetails>();
		for (Person p : persons) {
			Person mother = (p.getMotherId() != null) ? personRepository.findBy(p.getMotherId()) : null;
			Person father = (p.getFatherId() != null) ? personRepository.findBy(p.getFatherId()) : null;
			PersonDetails personDetails = new PersonDetails.Builder(p)
												.withMother(mother)
												.withFather(father)
												.build();
			listPersonDetails.add(personDetails);
		}
		return listPersonDetails;

	}	

//	@Override
//	public List<Person> listAllPersonDetails() {
//		return personRepository.findAll();
//	}		
	
}
