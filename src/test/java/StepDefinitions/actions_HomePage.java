package StepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.initializers.adv_initWebDriver;

import java.io.IOException;

import static utilities.webDefinitions.*;

public class actions_HomePage {

    @Before()
    public void RunSetup() throws IOException {
        adv_initWebDriver.setupWebDriver ();
        System.out.println ("Initiating WebDriver");
        log.info ("//**** Initiating WebDriver ****//");
    }

    @Given("User has reached on home page")
    public void validate_home_page() throws IOException {

        By page_title = By.cssSelector (OR_prop.getProperty ("home_page_css"));

        if (isElementPresent (page_title)) {
            System.out.println (("Navigated successfully to " + page_title));
            takeScreenshot ();
        }
    }

    @And ("User can navigate to the test screen")
    public void validate_testScreen () throws IOException {

        //Locate Navigational webElements
        WebElement nav_pt1 = driver.findElement (By.xpath (OR_prop.getProperty ("hp_button1_xpath")));
        WebElement nav_pt2 = driver.findElement (By.xpath (OR_prop.getProperty ("hp_button2_xpath")));

        waits (10);

        System.out.println ("We have two navigation points read as " + nav_pt1.getText () + " & " + nav_pt2.getText ());

        takeScreenshot ();
        if (nav_pt1.getText ().equals (OR_prop.getProperty ("navigational_direction"))) {
            setHighlighter (nav_pt1);
            nav_pt1.click ();

        } else {
            setHighlighter (nav_pt2);
            nav_pt2.click ();
        }
    }

    @When ("User is able to locate the desired Webpage to test")
    public void validate_testElement () throws IOException {

        waits (50);
        try{

            if (isElementPresent (By.cssSelector (OR_prop.getProperty ("tp_validator_css")))){

                WebElement tp_validator = driver.findElement (By.cssSelector (OR_prop.getProperty ("tp_validator_css")));

                if (tp_validator.getText ().contains ("tp_validator_css")){
                    setHighlighter (tp_validator);
                    takeScreenshot (tp_validator);

                    log.info ("Navigating to " +tp_validator.getText () );
                }
            }
        }
        catch (Exception exception){
            log.error (exception.getMessage ());
        }
    }

    @Then ("User can start executing the test steps")
    public void start_testExecution () throws IOException {

        System.out.printf ("---------Here begins the Test Execution----------");

    }
}
