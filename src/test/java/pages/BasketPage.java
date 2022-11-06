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
    }
    public void deleteProduct(){
        clickElement(By.xpath(productDelete));
        String title=findElement(By.className(emptyTitle)).getText();
        Assert.assertEquals("Basket is not Empty","Sepetinizde ürün bulunmamaktadır.",title);
    }
}
