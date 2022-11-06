package pages;

import base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static constants.Constants.*;

public class BasketPage extends BasePage {

    private String productPrice;

    public void getPriceProduct() {
        productPrice = findElement(By.xpath(price)).getText();
    }

    public void goBasket() {

        clickElement(By.xpath(basket));
    }

    public String getPriceBasket() {
        return findElement(By.cssSelector(basketPrice)).getText();
    }

    public void addToBasket() {
        Random rnd = new Random();

        List<WebElement> productSizes = findElements(By.xpath(productSize));
        int index = rnd.nextInt(productSizes.size());
        if (productSizes.get(index).isDisplayed()) {
            productSizes.get(index).click();
        }

        List<WebElement> productHeights = findElements(By.xpath(productHeight));
        int index2 = rnd.nextInt(productHeights.size());
        if (productHeights.get(index2).isDisplayed()) {
            productHeights.get(index2).click();
        }

        clickElement(By.id(addToBasketButton));
    }

    public void addQuantity() {
        clickElement(By.xpath(addQuantity));
    }

    public String getProductQuantity() {
        return findElement(By.xpath(productQuantity)).getText();
    }

    public void controlPrice() {
        getPriceProduct();
        addToBasket();
        goBasket();
        Assert.assertEquals("Price is Not Same", productPrice, getPriceBasket());
    }

    public void controlQuantity() {
        addQuantity();
        Assert.assertEquals("Quantity is Not Same", "(2 Ürün)", getProductQuantity());
    }
    public void deleteProduct(){
        clickElement(By.xpath(productDelete));
        String title=findElement(By.className(emptyTitle)).getText();
        Assert.assertEquals("Basket is not Empty","Sepetinizde ürün bulunmamaktadır.",title);
    }
}
