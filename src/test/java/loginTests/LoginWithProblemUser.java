package loginTests;

import baseTC.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWithProblemUser extends TestUtil {

    @Test
    public void successfulLoginWithProblemUser(){
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("performance_glitch_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[name=login-button]"));
        loginBtn.click();

        WebElement productsPageTitle = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        //Explicit Wait:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productsPageTitle));

        Assert.assertTrue(productsPageTitle.isDisplayed());
    }
}
