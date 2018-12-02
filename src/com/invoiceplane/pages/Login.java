package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dell on 11/17/2018.
 */
public class Login {

    WebDriver driver;

    @FindBy (name = "email")
    WebElement txtEmail;

    @FindBy (name = "password")
    WebElement txtPassword;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    WebElement btnLogin;


    public Login(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtEmail(String username)
    {
        txtEmail.sendKeys(username);

    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void  clickLogin()
    {
        btnLogin.click();
    }
}
