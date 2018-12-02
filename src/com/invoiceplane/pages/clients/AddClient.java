package com.invoiceplane.pages.clients;

import javafx.scene.control.CheckBox;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 11/17/2018.
 */
public class AddClient {

    WebDriver driver;

    @FindBy(xpath = "//*[@name=\"client_name\"]")
    WebElement ClientName;

    @FindBy(xpath = "//*[@name=\"client_active\"]" )
    WebElement ActiveCheckBox;

    @FindBy (xpath = "//*[@name=\"client_surname\"]")
    WebElement ClientSurname;

    @FindBy(xpath = "//*[@name=\"client_address_1\"]")
    WebElement SAddress1;

    @FindBy(xpath = "//*[@name=\"client_address_2\"]")
    WebElement SAddress2;

    @FindBy(xpath = "//*[@name=\"client_city\"]")
    WebElement city;

    @FindBy(xpath = "//*[@name=\"client_state\"]")
    WebElement state;

    @FindBy(xpath = "//*[@name=\"client_zip\"]")
    WebElement zipcode;

    @FindBy(xpath = "//*[@name=\"client_fax\"]")
    WebElement faxNum;

    @FindBy(xpath = "//*[@name=\"client_mobile\"]")
    WebElement MobNum;

    @FindBy(xpath = "//input[@name=\"client_phone\"]")
    WebElement phoneNum;

    @FindBy(xpath = "//*[@name=\"client_email\"]")
    WebElement EmailAddress;

    @FindBy(xpath = "//input[@name=\"client_web\"]")
    WebElement WebAddress;

    @FindBy(xpath = "//*[@name=\"client_vat_id\"]")
    WebElement VatId;

    @FindBy(xpath = "//*[@name=\"client_tax_code\"]")
    WebElement TaxCode;

    @FindBy(xpath = "//button[@name=\"btn_submit\"]")
    WebElement Csavebtn;

    @FindBy(xpath = "//span[@id=\"select2-client_country-container\"]")
    WebElement CountryDD;

    @FindBy(xpath = "//input[@class=\"select2-search__field\"]")
    WebElement CountryText;

    @FindBy(xpath = "//*[@id=\"select2-client_language-container\"]")
    WebElement LanguageDD;

    @FindBy(xpath = "//*[@class=\"select2-search__field\"]")
    WebElement LanguageText;




    @FindBy(xpath = "//input[@name=\"client_birthdate\"]")
    WebElement SeteDate;

    public AddClient(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtclientName(String Cname)
    {
        ClientName.sendKeys(Cname);
    }

    public void CheckBox()
    {
        if (ActiveCheckBox.isSelected()){
            System.out.println("checkbox is alredy selected");

        }
        else
        {
            ActiveCheckBox.click();
        }
    }

    public void setTxtclientSurname(String Csurname)
    {
        ClientSurname.sendKeys(Csurname);
    }

    public void Addresslin1(String add1)
    {
        SAddress1.sendKeys(add1);
    }

    public void Addresslin2(String add2)
    {
        SAddress2.sendKeys(add2);
    }
    public void setCity(String cityname)
    {
        city.sendKeys(cityname);
    }

    public void setState(String statename)
    {
        state.sendKeys(statename);
    }

    public void setZip(String zipno)
    {
        zipcode.sendKeys(zipno);
    }

    public void setFaxNum(String Faxnumber)
    {
        faxNum.sendKeys(Faxnumber);
    }

    public void mobile(String mobilenumber)
    {
        MobNum.sendKeys(mobilenumber);
    }

    public void setPhoneNum(String phoneNumber)
    {
        phoneNum.sendKeys(phoneNumber);
    }

    public void Emailadd(String Email)
    {
        EmailAddress.sendKeys(Email);
    }

    public void Webadd(String Web)
    {
        WebAddress.sendKeys(Web);
    }

    public void VatId (String Vat)
    {
      VatId.sendKeys(Vat);
    }

    public void TaxId (String Tax)
    {
        TaxCode.sendKeys(Tax);
    }
    public void  clickCsave()
    {
        Csavebtn.click();
    }

    public void setDate(String setDataStr) throws ParseException {

      //  String setDataStr = "05/05/2017"; //dd/MM/yyyy
        driver.findElement(By.xpath("//input[@name=\"client_birthdate\"]")).click();
        String currDateStr = driver.findElement(By.xpath("//th[contains(text(),'December')]")).getText(); //MM/yyyy

        SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy");

        Date setDate = sdSetDate.parse(setDataStr);


        SimpleDateFormat sdCurrDate =new SimpleDateFormat("MMMM yyyy");
        Date currDate = sdCurrDate.parse(currDateStr);


        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture = true;

        if (monthDiff<0) {

            isFuture = false;
            monthDiff = -1 * monthDiff;
        }

        for (int i =0; i<monthDiff; i++)
        {

            if(isFuture)
                driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[2]/th[3]")).click();
            else
                driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[2]/th[1]")).click();

        }

        String day;

        day = new SimpleDateFormat("dd").format(setDate);


        driver.findElement(By.xpath("//td[text()='"+Integer.parseInt(day)+"' and @class='day']")).click();

    }

    public void setCountry(String country)
    {
        CountryDD.click();
        CountryText.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();

    }


    public void setLanguage (String language)
    {
        LanguageDD.click();
        LanguageText.sendKeys(language);
        driver.findElement(By.xpath("//li[contains(@id,'"+language.toLowerCase()+"')]")).click();
    }
}
