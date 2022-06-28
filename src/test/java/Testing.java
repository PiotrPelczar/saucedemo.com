import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Testing {

    @Test
    public void TC1() {

        //Checking if user name box is visible

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        Assertions.assertEquals(true, user_name.isDisplayed());
        driver.quit();
    }

    @Test
    public void TC2() {

        //Checking if password box is visible

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement pss = driver.findElement(By.id("password"));
        Assertions.assertEquals(true, pss.isDisplayed());
        driver.quit();
    }

    @Test
    public void TC3() {

        //Checking if keys send to username box appear in it

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");


        Assertions.assertEquals("standard_user", user_name.getAttribute("value"));
        driver.quit();
    }

    @Test
    public void TC4() {

        //Checking if keys send to password box appear in it

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        Assertions.assertEquals("secret_sauce", password.getAttribute("value"));
        driver.quit();

    }

    @Test
    public void TC5() {

        //Login happy path

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "https://www.saucedemo.com/inventory.html" );
        driver.quit();

    }

    @Test
    public void TC6() {

        //Loggin using forbidden user name

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("DonaldDuck");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        WebElement failure = driver.findElement(By.className("error-button"));

        Assertions.assertEquals(true, failure.isDisplayed());
        driver.quit();


    }

    @Test
    public void TC7() {

        //Loggin using wrong password

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("MieckeyMouse");

        driver.findElement(By.id("login-button")).click();

        WebElement failure = driver.findElement(By.className("error-button"));

        Assertions.assertEquals(true, failure.isDisplayed());
        driver.quit();


    }

    @Test
    public void TC8() {

        //Loggin using wrong user name and wrong password

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("Goofy");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Pluto");

        driver.findElement(By.id("login-button")).click();

        WebElement failure = driver.findElement(By.className("error-button"));

        Assertions.assertEquals(true, failure.isDisplayed());
        driver.quit();

    }

    @Test
    public void TC9() {

        //Purchasing product happy path

        System.setProperty("webdriver.chrome.driver", "c:/Chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


        WebElement user_name = driver.findElement(By.id("user-name"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        Assertions.assertEquals("https://www.saucedemo.com/checkout-complete.html", driver.getCurrentUrl());


    }


    }
