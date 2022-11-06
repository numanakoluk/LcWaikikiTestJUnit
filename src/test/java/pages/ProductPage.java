package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static constants.Constants.*;

public class ProductPage extends BasePage {
    public void selectProduct() {
        Random rnd = new Random();
        List<WebElement> products = findElements(By.className(productList));
        int index = rnd.nextInt(products.size());
        products.get(index).click();
    }
}
