package com.martinetherton.ons.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.SelectOption;

public class HomePage {

	private final WebDriver driver;
	
	@FindBy(how = How.ID, using = "heading")
	private WebElement heading;

	@FindBy(how = How.ID, using = "surnameList")
	private WebElement surnameSelectionBox;
	
	@FindBy(how = How.ID, using = "search")
	private WebElement searchButton;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().equals("home");
            }
        });			
	}

	public String heading() {
		return heading.getText();
	}


	public void searchBySurname(String surname) {
		Select select = new Select(surnameSelectionBox);
		select.deselectAll();
		select.selectByValue(surname);
		searchButton.click();
	}
	


	
	
}
