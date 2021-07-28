package com.desafioseleniumV2.desafioseleniumV2;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hello {

    @Test
    public void Hello_World(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("http://automationpractice.com/index.php");
        browser.quit();
    }
}
