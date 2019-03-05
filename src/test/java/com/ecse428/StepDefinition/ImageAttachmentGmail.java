package com.ecse428.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

import org.openqa.selenium.chrome.ChromeDriver;

public class ImageAttachmentGmail {
    
    private final String PATH_TO_CHROME_DRIVER = "/Users/qingqing/Documents/workspace/School/ECSE428/chromedriver";
    private final String GMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
    private ChromeDriver driver;

    @Given("^Open Chrome and launch the application$")
    public void open_Chrome_and_launch_the_application() throws Throwable {
        System.out.println("This Step open Chrome and launch the application.");
        setupSeleniumChromeDriver();
        
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        getURL(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print the
         * result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // close Fire fox
        driver.close();
    }

    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable {
        System.out.println("This step enter the Username and Password on the login page.");
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable {
        System.out.println("This step click on the Reset button.");
    }

    // Helper functions
    private void setupSeleniumChromeDriver() throws MalformedURLException {
        if (driver == null) {
            System.out.println("Setting up ChromeDriver... ");
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
            System.out.print("Done!\n");
        }
    }

    private void getURL(String url) {
        if (driver != null) {
            System.out.println("Navigating to " + url);
            driver.get(url);
        }
    }
}
