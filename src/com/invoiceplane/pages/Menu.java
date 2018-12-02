package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by dell on 11/18/2018.
 */
public class Menu {

    WebDriver driver;

    @FindBy (xpath = "//*[contains(text(),'Clients')]")
    WebElement ClientMenu;

    @FindBy (xpath = "//a[contains(text(),'Add Client')]")
    WebElement AddClient;

    @FindBy (xpath = "//a[contains(text(),'View Clients')]")
    WebElement ViewClient;

    @FindBy (xpath = "//*[contains(text(),'Quotes')]")
    WebElement QuatoesMenu;

    @FindBy (xpath = "//a[contains(text(),'Create Quote')]")
    WebElement CreateQuatoe;

    @FindBy (xpath = "//a[contains(text(),'View Quotes')]")
    WebElement ViewQuatoes;

    @FindBy (xpath = "//*[contains(text(),'Invoices')]")
    WebElement InvoicesMenu;

    @FindBy (xpath = "//a[contains(text(),'Create Invoice')]")
    WebElement CreateInvoice;

    @FindBy (xpath = "//a[contains(text(),'View Invoices')]")
    WebElement CreateViewInvoices;

    @FindBy (xpath = "//a[contains(text(),'View Recurring Invoices')]")
    WebElement ViewRecurringInvoices;

    @FindBy (xpath = "//*[contains(text(),'Payments')]")  //find by- intialize page repo
    WebElement PaymentsMenu;

    @FindBy (xpath = "//*[contains(text(),'Enter Payment')]")
    WebElement EnterPayments;

    @FindBy (xpath = "//*[contains(text(),'View Payments')]")
    WebElement ViewPayments;

    @FindBy (xpath = "//*[contains(text(),'View Online Payments')]")
    WebElement ViewOnlinePayments;

    @FindBy (xpath = "//*[contains(text(),'Products')]")
    WebElement ProductsMenu;

    @FindBy (xpath = "//*[contains(text(),'Create product')]")
    WebElement CreateProduct;

    @FindBy (xpath = "//*[contains(text(),'View products')]")
    WebElement ViewProducts;

    @FindBy (xpath = "//*[contains(text(),'Product families')]")
    WebElement ProductFamilies;

    @FindBy (xpath = "//*[contains(text(),'Product Units')]")
    WebElement ProductUnits;


    public Menu(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void  ClickAddClient()
    {
        ClientMenu.click();
        AddClient.click();
    }

    public void ClickViewClient()
    {
        ClientMenu.click();
        ViewClient.click();
    }

}
