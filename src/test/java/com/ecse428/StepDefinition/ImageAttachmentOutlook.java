package com.ecse428.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class ImageAttachmentOutlook {
    
    private final String PATH_TO_CHROME_DRIVER = "/Users/qingqing/Documents/workspace/School/ECSE428/chromedriver";
    private final String OUTLOOK_SIGNIN_URL = "https://outlook.live.com/owa/?nlp=1";
    private final String EMAIL_ADDRESS = "fionawang.ecse428@hotmail.com";
    private final String EMAIL_PASSWORD = "ecse4282019";
//  private final String OUTLOOK_SIGNIN_URL = "https://outlook.live.com/owa";

//    private final String OUTLOOK_SENT_URL = "https://mail.google.com/mail/#sent";

    private ChromeDriver driver;
    private WebDriverWait wait;
    
    @Given("^I am on the new message page$")
    public void open_Chrome_launch_Outlook_and_new_message() throws Throwable {
        System.out.println("Open Chrome, launch the Outlook application, sign in and click on the compose button");
        // TODO: maybe add some print statements (that looks good? maybe) or clean up
        // TODO: modulate below
        // Setup the chrome driver
        if (driver == null) {
            System.out.println("Setting up ChromeDriver... ");
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
            System.out.print("Done!\n");
        }
        
        // Navigate to outlook main page
        navigateTo(OUTLOOK_SIGNIN_URL);
        
        // Input login email
        WebElement emailForm = driver.findElementById("i0116");
        emailForm.sendKeys(EMAIL_ADDRESS);
        // Input login password
        WebElement passForm = driver.findElementById("i0118");
        passForm.sendKeys(EMAIL_PASSWORD);
        // Click on next button
        WebElement nextBtn = driver.findElementById("idSIButton9");
        nextBtn.click();
        
        // TODO: move to @setup (how to do setup?)
        // Wait for the next page to appear and click on sign in button
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        WebElement signInBtn = driver.findElementById("idSIButton9");
        signInBtn.click();
        
        // Click on New Message button
        WebElement newMessBtn = driver.findElementById("id__3");
        newMessBtn.click();
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
    
    @And("I select a .png image over 33MB")
    public void attach_png_image_over25() throws Throwable {
        System.out.println("Attach a .png image that is over 33MB to the message");
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
    
    // helper function
    private void navigateTo(String url) {
        if (driver != null) {
            System.out.println("navigating to " + url);
            driver.get(url);
        }
    }
}
