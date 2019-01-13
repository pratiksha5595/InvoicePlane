package UITesting;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utlities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class loginTest {

    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);

    Login login = new Login(driver);

    @BeforeClass
    public void start() {

        ResourceBundle rb = ResourceBundle.getBundle("Invoiceplane");

        String urlstr = rb.getString("url");
        driver.get(urlstr);



    }
        @Test
        public void textuserVisiblity () {

            boolean expected = true;
            boolean actual = false;

            try {

                actual = login.txtEmail.isDisplayed();

                System.out.println("email is present");

            } catch (Exception e) {

                actual = false;
            }

            Assert.assertEquals(actual, expected, "Email textbox is missing in login page");

            //System.out.println("Email textbox is missing");
        }

        @Test
        public void textEnable(){

        login=new Login(driver);

        boolean expected = true;
        boolean actual = false;

        try{
            actual=login.txtEmail.isEnabled();
            System.out.println("Email field is editable");

        }

        catch (Exception e){
            actual=false;

        }

        Assert.assertEquals(actual,expected,"text field is not editable");
    }

    @Test
    public void passworddisplay(){

        login=new Login(driver);

    boolean expected = true;
    boolean actual = false;

        try{
        actual=login.txtPassword.isDisplayed();
        System.out.println("password field is present");

    }

        catch (Exception e){
        actual=false;

    }

        Assert.assertEquals(actual,expected,"password field is not present");
}

@Test
    public void passwordenable() {

    login = new Login(driver);

    boolean expected = true;
    boolean actual = false;

    try {
        actual = login.txtPassword.isEnabled();
        System.out.println("password field is editable");
    } catch (Exception e) {
        actual = false;
    }
    Assert.assertEquals(actual, expected, "password field is not ediatable");
}

@Test
    public void loginbtndisplay(){

    login=new Login(driver);

    boolean expected = true;
    boolean actual = false;

    try{
        actual=login.btnLogin.isDisplayed();
        System.out.println("login btn field is present");

    }

    catch (Exception e){
        actual=false;

    }

    Assert.assertEquals(actual,expected,"login btn field is not present");
}

@Test
    public void loginbtnenable(){
    login=new Login(driver);

    boolean expected = true;
    boolean actual = false;

    try{
        actual=login.btnLogin.isEnabled();
        System.out.println("login btn field is enable");

    }

    catch (Exception e){
        actual=false;

    }

    Assert.assertEquals(actual,expected,"login btn field is not enable");

}

@Test
    public void vertifylabelemail(){
    login=new Login(driver);
    String Expected ="Email";
    String actual="";

    try {
         actual=login.lblEmail.getText();
        System.out.println(actual);
        }
        catch (Exception e){

        actual="";
    }

    Assert.assertEquals(actual,Expected,"verification failed");

}

@Test
    public void labelpass(){
    login=new Login(driver);
    String Expected ="Pasword";
    String actual="";

    try {
        actual=login.lblpassword.getText();
        System.out.println(actual);
    }
    catch (Exception e){

        actual="";
    }

    Assert.assertEquals(actual,Expected,"verification failed");

}

    @Test
    public void LblPwdWatermarkVisibilty()
    {
        Login login=new Login(driver);
        String expected="Password";
        String actual="";
        try
        {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch(Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"Password watermark  is not matching");
        System.out.println("Password watermark checked");
    }


}



