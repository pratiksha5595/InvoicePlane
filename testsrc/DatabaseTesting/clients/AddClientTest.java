package DatabaseTesting.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.pages.clients.AddClient;
import com.invoiceplane.utlities.Driver;
import com.invoiceplane.utlities.dbCon;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import static com.invoiceplane.utlities.TakeScreenshot.takeScreenshot;
import static com.invoiceplane.utlities.convertcountry.convertcountry;

/**
 * Created by dell on 11/18/2018.
 */
public class AddClientTest {



    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
  //  ExtentReports extent;
    @BeforeClass

    public void login() {
        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

     //   extent = new ExtentReports("Reports/report.html",true, NetworkMode.OFFLINE);


        String url = rb.getString("url");

        driver.get(url);



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Login login = new Login(driver);
        login.setTxtEmail("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();




    }

    @Test(dataProvider = "getData")
    public void addclientTest(String Cname, String Csurname, String language, String Sadd, String Sadd2, String City,
                              String State, String Zip_code, String Country, String Phone_no, String Fax_no,
                              String Mobile_no, String Email, String Website, String Gender, String Bdate,
                              String Vat_id, String Tax_code) throws Exception {

        ArrayList<String> Expected = new ArrayList<String>();

        Expected.add(Cname);
        Expected.add(Csurname);
        Expected.add(language.toLowerCase());
        Expected.add(Sadd);
        Expected.add(Sadd2);
        Expected.add(City);
        Expected.add(State);
        Expected.add(Zip_code);
        Expected.add(Country.toLowerCase());
        Expected.add(Phone_no);
        Expected.add(Fax_no);
        Expected.add(Mobile_no);
        Expected.add(Email);
        Expected.add(Website);
        //Expected.add(Gender);
       // Expected.add(Bdate);
        Expected.add(Vat_id);
        Expected.add(Tax_code);



        //  ExtentTest test = extent.startTest("Login  test","to check login functionality using valid data");
        Menu menu = new Menu(driver);

        menu.ClickAddClient();

     //   test.log(LogStatus.INFO,"clicking on addclient");

        AddClient addClient = new AddClient(driver);

        addClient.setTxtclientName(Cname);
       // test.log(LogStatus.INFO,"add client name");
        addClient.CheckBox();
       // test.log(LogStatus.INFO,"check checkbox");
        addClient.setTxtclientSurname(Csurname);
       // test.log(LogStatus.INFO,"add surname");
        addClient.setLanguage(language);
       // test.log(LogStatus.INFO,"select language");
        addClient.Addresslin1(Sadd);
       // test.log(LogStatus.INFO,"add address line1");
        addClient.Addresslin2(Sadd2);
       // test.log(LogStatus.INFO,"add address line2");
        addClient.setCity(City);
        //test.log(LogStatus.INFO,"add city");
        addClient.setState(State);
       // test.log(LogStatus.INFO,"add state");
        addClient.setZip(Zip_code);
        //test.log(LogStatus.INFO,"add zip code");
        addClient.setCountry(Country);
      //  test.log(LogStatus.INFO,"add country");
        addClient.setPhoneNum(Phone_no);
       // test.log(LogStatus.INFO,"add phone number");
        addClient.setFaxNum(Fax_no);
       // test.log(LogStatus.INFO,"add fax number");
        addClient.mobile(Mobile_no);
      //  test.log(LogStatus.INFO,"add mobile number");
        addClient.Emailadd(Email);
       // test.log(LogStatus.INFO,"add email");
        addClient.Webadd(Website);
        //test.log(LogStatus.INFO,"add website");
        // addClient.setGender(Gender);
        // addClient.setDate(Bdate);
        addClient.VatId(Vat_id);
       // test.log(LogStatus.INFO,"add vat id");
        addClient.TaxId(Tax_code);
        //test.log(LogStatus.INFO,"add tax code");
        addClient.clickCsave();

        dbCon db = new dbCon();


        String sqlselect = "Select * from ip_clients where client_name='"+Cname+"'";

        ResultSet rs = db.getRecords(sqlselect);



        ArrayList<String> actual = new ArrayList<String>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(convertcountry(rs.getString("client_country")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }
        Assert.assertEquals(actual,Expected,"verification failed");
        System.out.println("Expected column");
        System.out.println(Expected);
        System.out.println("Actual column");
        System.out.println(actual);


    }

    @AfterClass
    public  void result(){

      //  extent.flush();

    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Data/Add_client.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet("sheet2");

        int rowCount= worksheet.getPhysicalNumberOfRows();

        Object[] [] data = new Object[rowCount-1][18];

        for (int i=1; i<rowCount; i++){

            HSSFRow row =worksheet.getRow(i);

            HSSFCell Cname = row.getCell(0);
            if (Cname == null)
                data[i-1][0] = "";
            else {
                Cname.setCellType(CellType.STRING);
                data[i-1][0] = Cname.getStringCellValue();
            }

            HSSFCell Csurname = row.getCell(1);
            if (Csurname == null)
                data[i-1][1] = "";
            else {
                Csurname.setCellType(CellType.STRING);
                data[i-1][1] = Csurname.getStringCellValue();
            }

            HSSFCell language = row.getCell(2);
            if (language == null)
                data[i-1][2] = "";
            else {
                language.setCellType(CellType.STRING);
                data[i-1][2] = language.getStringCellValue();
            }

            HSSFCell Sadd = row.getCell(3);
            if (Sadd == null)
                data[i-1][3] = "";
            else {
                Sadd.setCellType(CellType.STRING);
                data[i-1][3] = Sadd.getStringCellValue();
            }
            HSSFCell Sadd2 = row.getCell(4);
            if (Sadd2 == null)
                data[i-1][4] = "";
            else {
                Sadd2.setCellType(CellType.STRING);
                data[i-1][4] = Sadd2.getStringCellValue();
            }
            HSSFCell City = row.getCell(5);
            if (City == null)
                data[i-1][5] = "";
            else {
                City.setCellType(CellType.STRING);
                data[i-1][5] = City.getStringCellValue();
            }
            HSSFCell State = row.getCell(6);
            if (State == null)
                data[i-1][6] = "";
            else {
                State.setCellType(CellType.STRING);
                data[i-1][6] = State.getStringCellValue();
            }
            HSSFCell Zip_code = row.getCell(7);
            if (Zip_code == null)
                data[i-1][7] = "";
            else {
                Zip_code.setCellType(CellType.STRING);
                data[i-1][7] = Zip_code.getStringCellValue();
            }
            HSSFCell Country = row.getCell(8);
            if (Country == null)
                data[i-1][8] = "";
            else {
                Country.setCellType(CellType.STRING);
                data[i-1][8] = Country.getStringCellValue();
            }
            HSSFCell Phone_no = row.getCell(9);
            if (Phone_no == null)
                data[i-1][9] = "";
            else {
                Phone_no.setCellType(CellType.STRING);
                data[i-1][9] = Phone_no.getStringCellValue();
            }
            HSSFCell Fax_no = row.getCell(10);
            if (Fax_no == null)
                data[i-1][10] = "";
            else {
                Fax_no.setCellType(CellType.STRING);
                data[i-1][10] = Fax_no.getStringCellValue();
            }
            HSSFCell Mobile_no = row.getCell(11);
            if (Mobile_no == null)
                data[i-1][11] = "";
            else {
                Mobile_no.setCellType(CellType.STRING);
                data[i-1][11] = Mobile_no.getStringCellValue();
            }
            HSSFCell Email = row.getCell(12);
            if (Email == null)
                data[i-1][12] = "";
            else {
                Email.setCellType(CellType.STRING);
                data[i-1][12] = Email.getStringCellValue();
            }
            HSSFCell Website = row.getCell(13);
            if (Website == null)
                data[i-1][13] = "";
            else {
                Website.setCellType(CellType.STRING);
                data[i-1][13] = Website.getStringCellValue();
            }
            HSSFCell Gender = row.getCell(14);
            if (Gender == null)
                data[i-1][14] = "";
            else {
                Gender.setCellType(CellType.STRING);
                data[i-1][14] = Gender.getStringCellValue();
            }
            HSSFCell Bdate = row.getCell(15);
            if (Bdate == null)
                data[i-1][15] = "";
            else {
                Bdate.setCellType(CellType.STRING);
                data[i-1][15] = Bdate.getStringCellValue();
            }
            HSSFCell Vat_id = row.getCell(16);
            if (Vat_id == null)
                data[i-1][16] = "";
            else {
                Vat_id.setCellType(CellType.STRING);
                data[i-1][16] = Vat_id.getStringCellValue();
            }
            HSSFCell Tax_code = row.getCell(17);
            if (Tax_code == null)
                data[i-1][17] = "";
            else {
                Tax_code.setCellType(CellType.STRING);
                data[i-1][17] = Tax_code.getStringCellValue();
            }


        }

        return data;
    }


}
