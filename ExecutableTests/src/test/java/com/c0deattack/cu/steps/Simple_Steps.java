package com.c0deattack.cu.steps;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Simple_Steps extends Base_Steps {

    @Before
    public void setUp() {
        System.out.println("Entered setUp in Simple Steps");
        super.setUp();
    }

    @After
    public void tearDown() {
        getWebDriver().quit();
    }

    @Given("^that I am on google.com$")
    public void that_I_am_on_google_com() {
        WebDriver webDriver = getWebDriver();
        webDriver.get("http://www.google.com");

        String title = getWebDriver().getTitle();
        Assert.assertTrue(title.equals("Google"));
    }

    @Given("^that I am on amazon.com$")
    public void that_I_am_on_amazon_com() {
        WebDriver webDriver = getWebDriver();
        webDriver.get("http://www.amazon.com");

        String title = getWebDriver().getTitle();
        Assert.assertTrue(title.startsWith("Amazon.com"));
    }

    @Then("^I should see the search box$")
    public void I_should_see_the_search_box() {
        Assert.assertNotNull(getWebDriver().findElement(By.id("gs_lc0")));
    }

    @Then("^I should see the title Amazon.com$")
    public void I_should_see_the_title_Amazon_com() {
        String title = getWebDriver().getTitle();

        System.out.println("The title is: " + title);
        assertTrue(title.startsWith("Amazon.com"));
    }

}
