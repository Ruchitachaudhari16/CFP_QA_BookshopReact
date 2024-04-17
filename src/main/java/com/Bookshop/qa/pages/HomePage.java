package com.Bookshop.qa.pages;

import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.Bookshop.qa.baseclass.BaseClass.driver;

public class HomePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath = "//input[@placeholder='Which book are you looking for?']")
    WebElement searchBar;

    @FindBy(xpath = "/html/body/div/div/div/main/div[4]/div[2]/div/div/div[2]/button")
    WebElement littlePrincessAddCart;

    @FindBy(xpath = "/html/body/div/div/div/div/header/div/div[2]/a/span[1]/span/svg")
    WebElement cart;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBook(String bookName) {
        searchBar.sendKeys(bookName+"\n");
    }

    public void addToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll the element into view
        js.executeScript("arguments[0].scrollIntoView(true);", littlePrincessAddCart);

        // Wait for the element to be clickable
        WebElement addCartButton = wait.until(ExpectedConditions.elementToBeClickable(littlePrincessAddCart));

        // Click the element
        addCartButton.click();

    }

}
