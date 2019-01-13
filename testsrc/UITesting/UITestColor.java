package UITesting;

import com.invoiceplane.utlities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

public class UITestColor {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    @BeforeClass
    public void start() {

        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

        String urlstr = rb.getString("url");
        driver.get(urlstr);



    }

    @Test
    public void colortest(){



    }
}
