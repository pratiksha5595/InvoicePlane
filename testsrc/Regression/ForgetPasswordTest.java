package Regression;

import com.invoiceplane.pages.ForgetPassword;
import com.invoiceplane.utlities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by dell on 11/17/2018.
 */
public class ForgetPasswordTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    @Test

    public void forgotPassTest() {
        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

        String url = rb.getString("url");

        driver.get(url);

        ForgetPassword fp = new ForgetPassword(driver);
        fp.ClickForgot();
        fp.setFemail("radha.padwal@gmail.com");
        fp.clickFbtn();

    }
}
