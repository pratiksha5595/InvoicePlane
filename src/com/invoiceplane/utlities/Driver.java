package com.invoiceplane.utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 11/18/2018.
 */
public class Driver {

    private static WebDriver myDriver;

    private static long timeout =10;

    public enum DriverTypes {
        FIREFOX,CHROME
    }

    public static WebDriver getDriver (DriverTypes d){
        if(myDriver==null){

            switch (d){

                case CHROME:
                    System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
                    myDriver = new ChromeDriver();
                    break;

                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
                    myDriver = new FirefoxDriver();
                    break;
            }

            myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            myDriver.manage().window().maximize();
        }
        timeout=10;
        return myDriver;
    }
}
