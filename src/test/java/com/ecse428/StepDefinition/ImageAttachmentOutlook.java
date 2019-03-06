package com.ecse428.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class ImageAttachmentOutlook {
    // TODO: add all the name, id, default sec to wait, as final string?
    
    private final String PATH_TO_CHROME_DRIVER = "/Users/qingqing/Documents/workspace/School/ECSE428/chromedriver";
    private final String OUTLOOK_SIGNIN_URL = "https://outlook.live.com/owa/?nlp=1";
    private final String EMAIL_ADDRESS = "fionawang.ecse428@hotmail.com";
    private final String EMAIL_PASSWORD = "ecse4282019";

    private ChromeDriver driver;
    private WebDriverWait wait;
    
    @Before
    /** Function run before every scenario */
    public void setUp() throws Throwable{        
        // Initialize the chrome driver
        setupChromeDriver();

        // Initialize the wait driver to default 15 sec wait for conditions
        if (wait == null) {
            wait = new WebDriverWait(driver, 15);
        }
        
        // Navigate to outlook and sign in
        openChromeSignIn();
        
        // TODO: VERIFY INITIAL STATE HERE
    }
    
    @After
    /** Function run after every scenario */
    public void tearDown() throws Throwable{
        // TODO: VERIFY INITIAL STATE HERE

        // TODO: uncomment the below line to close drivers when task is done
//        driver.close();
    }
    
    @Given("^I am on the new message page$")
    public void click_new_message_button() throws Throwable {
        System.out.println("Step: Click on the new message button");
        
        // Find new message button by id and click on it
        WebElement newMessBtn = driver.findElementById("id__3");
        newMessBtn.click();
    }
    
    @And("^I have selected a single email recipient$")
    public void enter_single_email_recipient() throws Throwable{
        System.out.println("Step: Enter email recipient");
    }
    
    @And("^I have selected a two email recipient$")
    public void enter_two_email_recipients() throws Throwable{
        System.out.println("Step: Enter two email recipients");
    }

    @When("^I attach a .png image$")
    public void attach_png_image() throws Throwable {
        System.out.println("Step: Attach a .png image to the message");
        // Wait for attach button to appear and click on it
        WebElement attachBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Attach")));
        attachBtn.click();
        // Find the file input and upload files to it
        WebElement browseComputerBtn = driver.findElementByClassName("_1iWL2ddLCtiEp9P-UVh8nV");
        browseComputerBtn.sendKeys("/Users/qingqing/Downloads/test.png");
    }

    @When("^I attach two .png images$")
    public void attach_two_png_image() throws Throwable {
        System.out.println("Step: Attach a .png image to the message");
    }
    
    @When("I attach a .png image over 33MB")
    public void attach_png_image_over25() throws Throwable {
        System.out.println("Step: Attach a .png image that is over 33MB to the message");
    }
    
    @When("^I attach a .jpeg image$")
    public void attach_jpeg_image() throws Throwable {
        System.out.println("Step: Attach a .jpeg image to the message");
    }
    
    @And("^I click on “send” button$")
    public void click_send_button() throws Throwable {
        System.out.println("Step: Click on send button");
    }
    
    @Then("^I should be able to see the email in my “Sent” folder$")
    public void verify_email_sent() throws Throwable {
        System.out.println("Step: Verify email is sent");
    }
    
    @Then("^a file too large error message appears$")
    public void verify_file_too_large_error() throws Throwable {
        System.out.println("Step: Verify file too large error message appears");
    }
    
    // TODO: Mayb move them outside of this class
    // Helper Functions
    /** Create chrome driver, navigate to outlook and sign in */
    private void openChromeSignIn() {
        System.out.println("Step: Open Chrome, launch the Outlook application and sign in");
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
        
        // Wait for the next page to appear and click on sign in button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("i0118")));
        WebElement signInBtn = driver.findElementById("idSIButton9");
        signInBtn.click();
    }
    
    /** Create chrome driver and set its path to where the chrome driver exec is found */
    private void setupChromeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
        }
    }
    
    /** Navigate to the given url */
    private void navigateTo(String url) {
        if (driver != null) {
            driver.get(url);
        }
    }
}
