package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dell on 11/17/2018.
 */
public class ForgetPassword {

    WebDriver driver;

    @FindBy (xpath = "//a[contains(text(),'forgot')]")
    WebElement fpass;

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement femail;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    WebElement fbtn;


    public ForgetPassword(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void ClickForgot(){

        fpass.click();
    }

    public void setFemail(String Email)
    {
        femail.sendKeys(Email);
    }

    public void clickFbtn()
    {
    fbtn.click();

    }

}