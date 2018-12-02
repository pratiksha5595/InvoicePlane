package Regression.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.pages.clients.AddClient;
import com.invoiceplane.utlities.Driver;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Created by dell on 11/18/2018.
 */
public class AddClientTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    @BeforeClass

    public void login() {
        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

        String url = rb.getString("url");

        driver.get(url);

        Login login = new Login(driver);
        login.setTxtEmail("radha.padwal@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();

    }

    @Test(dataProvider = "getData")
    public void addclientTest(String Cname, String Csurname, String language, String Sadd, String Sadd2, String City, String State, String Zip_code, String Country, String Phone_no, String Fax_no, String Mobile_no, String Email, String Website, String Gender, String Bdate, String Vat_id, String Tax_code
    ) throws ParseException {
        Menu menu = new Menu(driver);

        menu.ClickAddClient();
        AddClient addClient = new AddClient(driver);

        addClient.setTxtclientName(Cname);
        addClient.CheckBox();
        addClient.setTxtclientSurname(Csurname);
        addClient.setLanguage(language);
        addClient.Addresslin1(Sadd);
        addClient.Addresslin1(Sadd2);
        addClient.setCity(City);
        addClient.setState(State);
        addClient.setZip(Zip_code);
        addClient.setCountry(Country);
        addClient.setPhoneNum(Phone_no);
        addClient.setFaxNum(Fax_no);
        addClient.mobile(Mobile_no);
        addClient.Emailadd(Email);
        addClient.Webadd(Website);
        // addClient.set(Gender);
        addClient.setDate(Bdate);
        addClient.VatId(Vat_id);
        addClient.TaxId(Tax_code);

        addClient.clickCsave();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Add_client.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet("sheet1");

    }


}
