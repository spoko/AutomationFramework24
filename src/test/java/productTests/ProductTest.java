package productTests;

import baseTC.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends TestUtil {
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @Test(dataProvider = "items to be added")
    public void addProductToTheCart(String item){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + item));
        itemToBeAdded.click();

        WebElement shoppingCartBadge = driver.findElement(By.cssSelector(".shopping_cart_badge"));

        Assert.assertEquals(shoppingCartBadge.getText(), "1");
    }
}
