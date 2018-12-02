package Regression;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utlities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by dell on 11/17/2018.
 */
public class LoginTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    @Test

    public void logintest()
    {
        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

        String url = rb.getString("url");

        driver.get(url);

        Login login = new Login(driver);
        login.setTxtEmail("radha.padwal@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();

    }


}
