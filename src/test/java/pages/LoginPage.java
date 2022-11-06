package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

import static constants.Constants.*;


public class LoginPage extends BasePage {

    public void close(){
        clickElement(By.xpath("//*[@id=\"close-button-1454703513202\"]/span"));
    }

    public void ControlPageLoad() {
        Assert.assertEquals("https://www.lcwaikiki.com/tr-TR/TR", driver.getCurrentUrl());
    }

    public void GoLogin() {
        clickElement(By.xpath(headerLoginButton));
    }

    public void beLogin(String userName, String password) {
        findElement(By.id(eMail)).sendKeys(userName);
        findElement(By.id(pass)).sendKeys(password);
        clickElement(By.id(loginButton));

    }
}
