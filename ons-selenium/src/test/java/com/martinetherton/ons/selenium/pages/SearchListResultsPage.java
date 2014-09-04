package com.martinetherton.ons.selenium.pages;

import java.io.Serializable;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchListResultsPage {

	private final WebDriver driver;
	
	@FindBy(how = How.ID, using = "heading")
	private WebElement heading;	
	
	@FindBy(how = How.XPATH, using = "//tr")
	private List<WebElement> searchListRows;
	
	public SearchListResultsPage(WebDriver driver) {
		this.driver = driver;
        // Check that we're on the right page.
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().equals("search results");
            }
        });			
	}	
	
	public String heading() {
		return heading.getText();
	}

	public int numberOfRows() {
		// TODO Auto-generated method stub
		return searchListRows.size();
	}	
	
}
