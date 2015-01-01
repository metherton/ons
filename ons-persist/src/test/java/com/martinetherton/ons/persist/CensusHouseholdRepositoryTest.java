package com.martinetherton.ons.persist;

import com.martinetherton.ons.model.Census;
import com.martinetherton.ons.model.CensusHousehold;
import com.martinetherton.ons.model.Location;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by martin on 11/12/14.
 */
public class CensusHouseholdRepositoryTest {

    CensusHouseholdRepository repository;
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @Before
    public void setUpPersonRepository() {
        entityManagerFactory = createEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        repository = new CensusHouseholdRepositoryImpl();
        repository.setEntityManager(entityManager);
    }

    @Test
    public void findAllCensusHouseholds() {
        List<CensusHousehold> censusHouseholds = repository.findAll();
        assertThat(censusHouseholds.size(), is(Matchers.greaterThan(0)));
    }

    @Test
    public void findCensusHouseholdForCensusAndLocation() {
        Census census = new Census();
        census.setEntityId(0L);
        Location location = new Location();
        location.setEntityId(0L);
        CensusHousehold censusHousehold = repository.findCensusHousehold(census, location);
        assertThat(censusHousehold.getEntityId(), is(0L));
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
