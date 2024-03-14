package testsPOM;

import baseTC.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesPOM.LoginPage;
import pagesPOM.ProductsPage;

public class LoginTests extends TestUtil {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isAt());
    }
}
