package Regression.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.pages.clients.AddClient;
import com.invoiceplane.utlities.Driver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
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
        login.setTxtEmail("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();

        Menu menu = new Menu(driver);

        menu.ClickAddClient();

    }

    @Test(dataProvider = "getData")
    public void addclientTest(String Cname, String Csurname, String language, String Sadd, String Sadd2, String City,
                              String State, String Zip_code, String Country, String Phone_no, String Fax_no,
                              String Mobile_no, String Email, String Website, String Gender, String Bdate,
                              String Vat_id, String Tax_code) throws ParseException {

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
        // addClient.setGender(Gender);
        addClient.setDate(Bdate);
        addClient.VatId(Vat_id);
        addClient.TaxId(Tax_code);

        addClient.clickCsave();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("Data/Add_client.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet("sheet1");

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
                data[i-1][13] = Sadd2.getStringCellValue();
            }
//            HSSFCell Gender = row.getCell(0);
//            if (Gender == null)
//                data[i-1][14] = "";
//            else {
//                Gender.setCellType(CellType.STRING);
//                data[i-1][14] = Gender.getStringCellValue();
//            }
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
