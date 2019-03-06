package com.ecse428.StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class ImageAttachmentOutlook {

    private final String PATH_TO_CHROME_DRIVER = "/Users/qingqing/Documents/workspace/School/ECSE428/chromedriver";
    private final String OUTLOOK_SIGNIN_URL = "https://outlook.live.com/owa/?nlp=1";
    private final String OUTLOOK_INBOX_TITLE = "Mail - Fiona Wang - Outlook";
    private final String EMAIL_ADDRESS = "fionawang.ecse428@hotmail.com";
    private final String EMAIL_PASSWORD = "ecse4282019";
    private final String IMAGE_FILE_DIRECTORY = "src/test/resources/";

    private final String NEW_MSG_BTN_ID = "id__3";
    private final String EMAIL_FORM_ID = "i0116";
    private final String PASS_FORM_ID = "i0118";
    private final String SIGNIN_BTN_ID = "idSIButton9";
    private final String ATTACH_BTN_NAME = "Attach";
    private final String FILE_INPUT_CLASSNAME = "_1iWL2ddLCtiEp9P-UVh8nV";
    private final String UPLOADED_FILE_CLASSNAME = "is-fadeIn";
    private final String ERROR_MSG_CLASSNAME = "_3c57Fvb9-GOxD8a2WZ2cw-";

    private final int TIME_WAIT_FOR_CONDITION = 15;

    private ChromeDriver driver;
    private WebDriverWait wait;

    @Before
    /** Function run before every scenario */
    public void setUp() throws Throwable {
        // Initialize the chrome driver
        setupChromeDriver();
        // Initialize the wait driver to default 15 sec wait for conditions
        if (wait == null) {
            wait = new WebDriverWait(driver, TIME_WAIT_FOR_CONDITION);
        }

        // Navigate to outlook and sign in
        openChromeSignIn();

        // verify initial state after test is run (in the outlook inbox)
        System.out.println(driver.getTitle());
        Assert.assertTrue(verifyInitialState());
    }

    @After
    /** Function run after every scenario */
    public void tearDown() throws Throwable {
        // verify initial state after test is run (still in the outlook inbox)
        Assert.assertTrue(verifyInitialState());

        // TODO: uncomment the below line to close drivers when task is done
        // close the driver after each test
        driver.close();
    }

    @Given("^I am on the new message page$")
    public void click_new_message_button() throws Throwable {
        System.out.println("Step: Click on the new message button");

        // Find new message button by id and click on it
        try {
            WebElement newMessBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NEW_MSG_BTN_ID)));
            newMessBtn.click();
        } catch (Exception e) {
            printErrorMsg(e);
        }
    }

    @And("^I have selected a single email recipient$")
    public void enter_single_email_recipient() throws Throwable {
        System.out.println("Step: Enter email recipient");
    }

    @And("^I have selected a two email recipient$")
    public void enter_two_email_recipients() throws Throwable {
        System.out.println("Step: Enter two email recipients");
    }

    @When("^I attach a .png image$")
    public void attach_png_image() throws Throwable {
        System.out.println("Step: Attach a .png image to the message");
        // Upload only one .png file
        uploadFiles(new String[] { "test.png" }, true);
    }

    @When("^I attach two .png images$")
    public void attach_two_png_image() throws Throwable {
        System.out.println("Step: Attach a .png image to the message");
        // Upload only two .png files
        uploadFiles(new String[] { "test.png", "test2.png" }, true);
    }

    @When("I attach a .png image over 33MB")
    public void attach_png_image_over33() throws Throwable {
        System.out.println("Step: Attach a .png image that is over 33MB to the message");
        // Upload only one .png file that is over 33MB (100MB in our example)
        uploadFiles(new String[] { "test4.png" }, false);
    }

    @When("^I attach a .jpeg image$")
    public void attach_jpeg_image() throws Throwable {
        System.out.println("Step: Attach a .jpeg image to the message");
        // Upload only one .jpeg file
        uploadFiles(new String[] { "test3.jpg" }, true);
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
        // Find error message and assert it
        try {
            WebElement errMsg = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className(ERROR_MSG_CLASSNAME)));
            Assert.assertTrue(errMsg.isEnabled());
        } catch (Exception e) {
            printErrorMsg(e);
        }
    }

    // TODO: Maybe move them outside of this class
    // Helper Functions
    /**
     * Verify that the system is in initial state, in our case, the initial state is
     * when the system is in the outlook inbox
     */
    private boolean verifyInitialState() {
        return driver.getTitle().equals(OUTLOOK_INBOX_TITLE);
    }

    /** Create chrome driver, navigate to outlook and sign in */
    private void openChromeSignIn() {
        System.out.println("Step: Open Chrome, launch the Outlook application and sign in");
        // Navigate to outlook main page
        navigateTo(OUTLOOK_SIGNIN_URL);
        try {
            // Input login email
            WebElement emailForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL_FORM_ID)));
            emailForm.sendKeys(EMAIL_ADDRESS);
            // Input login password
            WebElement passForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(PASS_FORM_ID)));
            passForm.sendKeys(EMAIL_PASSWORD);
            // Click on next button
            WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIGNIN_BTN_ID)));
            nextBtn.click();

            // Wait for the next page to appear and click on sign in button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASS_FORM_ID)));
            WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SIGNIN_BTN_ID)));
            signInBtn.click();
        } catch (Exception e) {
            printErrorMsg(e);
        }
    }

    /**
     * Create chrome driver and set its path to where the chrome driver exec is
     * found
     */
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

    /** Upload a number of files to a new message */
    private void uploadFiles(String[] files, boolean waitForLoad) {
        try {
            // Wait for attach button to appear and click on it
            WebElement attachBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(ATTACH_BTN_NAME)));
            attachBtn.click();

            // Find the file input and upload files to it
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < files.length; i++) {
                // For each file, find its absolute path and add it to the input string
                input.append(new File(IMAGE_FILE_DIRECTORY + files[i]).getAbsolutePath());
                if (i != files.length - 1) {
                    input.append(" \n ");
                }
            }
            WebElement fileInput = driver.findElementByClassName(FILE_INPUT_CLASSNAME);
            fileInput.sendKeys(input);

            // Wait for images to be loaded
            if (waitForLoad) {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(UPLOADED_FILE_CLASSNAME)));
            }

        } catch (Exception e) {
            printErrorMsg(e);
        }
    }

    /** Print comprehensible error message */
    private void printErrorMsg(Exception e) {
        System.out.println("A web component was not found, the load time of your computer may be too long, "
                + "consider raising the final variable TIME_WAIT_FOR_CONDITION");
        System.out.println("Here is the stack trace: \n" + e.getMessage());
    }
}
