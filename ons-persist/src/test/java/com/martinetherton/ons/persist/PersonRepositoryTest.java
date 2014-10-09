package com.martinetherton.ons.persist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.martinetherton.ons.model.Person;
import com.martinetherton.ons.model.Surname;

public class PersonRepositoryTest {

    private PersonRepository repository;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    
    @Before
    public void setUpPersonRepository() {
        entityManagerFactory = createEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repository = new PersonRepositoryImpl();
        repository.setEntityManager(entityManager);        
    }
    
    @Test
    public void findPersonById() {
        long id = 0;
        Person person = repository.findBy(id);
        assertNotNull(person);
        assertThat(person.getFirstName(), is("Martin"));
        assertThat(person.getFather().getFirstName(), is("Sydney"));
        assertThat(person.getMother().getFirstName(), is("Nora"));
    }
    
    @Test
    public void findPersonsBySurname() {
        Surname surname = new Surname("Etherton");
        List<Person> persons = repository.findBy(surname);
        assertThat(persons.size(), is(4));
    }
   

    @Test
    @Ignore
    public void findOldestPerson() {
        Person person = repository.findEarliestPerson();
        assertThat(person.getFirstName(), is("Samuel Original"));
    }
    
    @Test
    public void populatePersonCache() {
        repository.populateCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(6));
    }
    
    @Test
    @Ignore
    public void newPersonAdded() {
    	Person person = new Person();
    	person.setFirstName("PERSON_FIRST_NAME");
    	Person father = new Person();
    	father.setFirstName("FATHER_FIRST_NAME");
    	Person mother = new Person();
    	mother.setFirstName("MOTHER_FIRST_NAME");
    	Surname surname = new Surname("A_SURNAME");
    	person.setSurname(surname);
    	person.setFather(father);
    	person.setMother(mother);
    	int numberOfPersonBefore = (repository.findAll()).size();
    	Person newPerson = repository.add(person);
    	assertThat((repository.findAll()).size(), Matchers.is(numberOfPersonBefore + 1));
    }
    
    @Test
    public void clearCache() {
        repository.populateCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(6));
        repository.clearCache();
        Assert.assertThat(repository.getPersonCache().size(), Matchers.is(0));
    }    
    
    @Test
    public void findAllPersons() {
        List<Person> persons = repository.findAll();
        assertThat(persons.size(), is(6));
    }
    
    private EntityManagerFactory createEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(createTestDataSource());
        
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.HSQL);
        jpaVendorAdapter.setShowSql(true);
        
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        
        Map<String, String> jpaProperties = new HashMap<String, String>();
        jpaProperties.put("hibernate.format_sql", "true");
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }    

    @After
    public void shutdownAccountRepository(){
        if(entityManager != null){
            entityManager.close();
        }
        
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }
        
    
    /**
     * We are not using Spring in this unit test, so we have to setup our
     * embedded database manually.
     * 
     * @return The factory.
     */
    private DataSource createTestDataSource() {
        return new EmbeddedDatabaseBuilder()
        .setName("ons")
        .addScript("classpath:/META-INF/db/schema.sql")
        .addScript("classpath:/META-INF/db/test-data.sql")
        .build();        
    }        
    
}
