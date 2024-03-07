package loginTests;

import baseTC.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnSuccessfulLogin extends TestUtil {

    @Test
    public void UnsuccessfulLogin(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("wrongUser");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement closeErrorMsgBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(closeErrorMsgBtn.isDisplayed());
    }
}
