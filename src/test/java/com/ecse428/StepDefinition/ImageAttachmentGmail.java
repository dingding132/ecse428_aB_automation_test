package com.ecse428.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import org.openqa.selenium.chrome.ChromeDriver;

public class ImageAttachmentGmail {
    
    private final String PATH_TO_CHROME_DRIVER = "/Users/qingqing/Documents/workspace/School/ECSE428/chromedriver";
    private final String GMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
    private ChromeDriver driver;

    @Given("^I am on the new message page$")
    public void open_Chrome_launch_Gmail_and_new_message() throws Throwable {
        System.out.println("Open Chrome, launch the Gmail application and clik on the compose button");
        
        if (driver == null) {
            System.out.println("Setting up ChromeDriver... ");
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
            System.out.print("Done!\n");
        }
        
        // EXAMPLE TEST, navigate to a random webpage and check that the title of the page is mercury tours
//        
//        String baseUrl = "http://demo.guru99.com/test/newtours/";
//        String expectedTitle = "Welcome: Mercury Tours";
//        String actualTitle = "";
//
//        // launch Fire fox and direct it to the Base URL
//        if (driver != null) {
//        System.out.println("Navigating to " + baseUrl);
//        driver.get(baseUrl);
//    }
//
//        // get the actual value of the title
//        actualTitle = driver.getTitle();
//
//        /*
//         * compare the actual title of the page with the expected one and print the
//         * result as "Passed" or "Failed"
//         */
//        if (actualTitle.contentEquals(expectedTitle)) {
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Test Failed");
//        }
//
//        // close Fire fox
//        driver.close();
    }
    
    @And("^I have selected a single email recipient$")
    public void enter_single_email_recipient() throws Throwable{
        System.out.println("Enter email recipient");
    }
    
    @And("^I have selected a two email recipient$")
    public void enter_two_email_recipients() throws Throwable{
        System.out.println("Enter two email recipients");
    }
    
    @When("^I click on the attach file button$")
    public void click_attach_file_button() throws Throwable {
        System.out.println("Click on attach file button");
    }

    @Then("^I select a .png image I want to attach$")
    public void attach_png_image() throws Throwable {
        System.out.println("Attach a .png image to the message");
    }

    @And("^I select two .png images I want to attach$")
    public void attach_two_png_image() throws Throwable {
        System.out.println("Attach a .png image to the message");
    }
    
    @And("I select a .png image over 25MB")
    public void attach_png_image_over25() throws Throwable {
        System.out.println("Attach a .png image that is over 25MB to the message");
    }
    
    @And("^I select a .jpeg image I want to attach$")
    public void attach_jpeg_image() throws Throwable {
        System.out.println("Attach a .jpeg image to the message");
    }
    
    @And("^I click on “send” button$")
    public void click_send_button() throws Throwable {
        System.out.println("Click on send button");
    }
    
    @Then("^I should be able to see the email in my “Sent” folder$")
    public void verify_email_sent() throws Throwable {
        System.out.println("Verify email is sent");
    }
    @Then("^a file too large error message appears$")
    public void verify_file_too_large_error() throws Throwable {
        System.out.println("Verify file too large error message appears");
    }
}
