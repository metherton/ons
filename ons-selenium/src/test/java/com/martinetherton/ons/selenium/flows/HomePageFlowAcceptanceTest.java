package com.martinetherton.ons.selenium.flows;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.martinetherton.ons.selenium.pages.HomePage;
import com.martinetherton.ons.selenium.pages.SearchListResultsPage;

public class HomePageFlowAcceptanceTest {

	private HomePage homePage;
	private WebDriver driver;
	
    @Before
    public void setUp() {
    	driver = new FirefoxDriver();
        driver.get("http://localhost:8080/ons-webapp");
        homePage = PageFactory.initElements(driver, HomePage.class);
    }	

    @After
    public void tearDown() {
    	driver.quit();
    }
    
    @Test
    @Ignore
    public void homePage() {
    	assertThat(homePage.heading(), is("Welcome to the Etherton One Name Study"));
    }     
    
    @Test
    @Ignore
    public void searchForAnEthertonBySurnameShouldReturnAListOfEthertons() {
    	SearchListResultsPage searchBySurname = homePage.searchBySurname("Etherton");
    	assertThat(searchBySurname.numberOfRows(),Matchers.is(4));
    }
    
}
