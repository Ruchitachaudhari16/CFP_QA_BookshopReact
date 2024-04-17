    package com.Bookshop.qa.testcases;

    import com.Bookshop.qa.pages.HomePage;
    import org.openqa.selenium.By;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriverException;
    import org.testng.Assert;
    import org.testng.annotations.AfterMethod;
    import org.testng.annotations.BeforeMethod;
    import org.testng.annotations.Listeners;
    import org.testng.annotations.Test;
    import io.qameta.allure.Description;
    import io.qameta.allure.Severity;
    import io.qameta.allure.SeverityLevel;
    import io.qameta.allure.Story;

    import static com.Bookshop.qa.baseclass.BaseClass.*;

    public class HomePageTest {

        public HomePage homePage;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        public HomePageTest(){
            super();
        }

        @BeforeMethod
        public void setUp() throws InterruptedException {
            try {
                initialization();
                homePage = new HomePage();
                js = (JavascriptExecutor) driver;
            } catch (WebDriverException e){
                e.printStackTrace();
            }
        }

        @Test
        public void searchBookTest() throws InterruptedException {
            Thread.sleep(5000);
            homePage.searchBook(properties.getProperty("bookname"));
        }

        @Test
        public void addToCartTest() throws InterruptedException {
            Thread.sleep(5000);
            homePage.searchBook(properties.getProperty("checkBook"));
            Thread.sleep(3000);
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(10000);
            homePage.addToCart();
        }
    }
