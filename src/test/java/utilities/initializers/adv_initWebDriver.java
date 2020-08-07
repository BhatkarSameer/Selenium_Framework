package utilities.initializers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class adv_initWebDriver extends initLogs {

    public static WebDriver driver;

    public static Properties config_prop = new Properties ();
    public static Properties OR_prop = new Properties ();

    public static FileInputStream ip_stream = null;

    public static String url;

    public static void setupWebDriver() throws IOException {

        try {
            ip_stream = new FileInputStream ("src/test/resources/properties/Config.properties");
            config_prop.load (ip_stream);

            ip_stream = new FileInputStream ("src/test/resources/properties/OR.properties");
            OR_prop.load (ip_stream);

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }


        //Read config settings
        String browserName = config_prop.getProperty ("browserName");
        url = config_prop.getProperty ("testUrl");

        //Call browser method with the config setting for browser name
        setDriver (browserName);

        //Load URL
        driver.get (url);
        driver.manage ().window ().maximize ();
        log.info ("Requested URL is launched");

    }

    public static void setDriver(String s) {

        switch (s) {
            case "Chrome" -> {
                WebDriverManager.chromedriver ().setup ();
                driver = new ChromeDriver ();
                log.info ("Google Chrome is being launched to Run the tests");
            }
            case "IE" -> {
                WebDriverManager.iedriver ().setup ();
                driver = new InternetExplorerDriver ();
                log.info ("Internet Explorer is being launched to Run the tests");
            }
            case "Firefox" -> {
                WebDriverManager.firefoxdriver ().setup ();
                driver = new FirefoxDriver ();
                log.info ("Firefox is being launched to Run the tests");
            }
            case "Edge" -> {
                WebDriverManager.edgedriver ().setup ();
                driver = new EdgeDriver ();
                log.info ("Microsoft Edge is being launched to Run the tests");
            }
            default -> throw new IllegalStateException ("Unexpected value: " + s);
        }

    }

}
