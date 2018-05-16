/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import de.lars.menu.components.backend.MenuGroupHeaderTitle;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author syrinx
 */
public class DemoServiceTest {

    @Test
    public void startWebDriver() {
        Assert.fail("haha");
        System.setProperty("webdriver.gecko.driver", "k:\\Programme\\_WebDriver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/demo_10_menu/");

        Assert.assertEquals("Backend", driver.getTitle());

        WebElement element = driver.findElement(By.id(MenuGroupHeaderTitle.ID + "_Demo"));
        element.click();

        Assert.fail("haha");
        element.sendKeys("test");
        element.sendKeys(" weiter");
        element = driver.findElement(By.id("lst-ib"));
        Assert.assertEquals("hallo", element.getText());
    }

    @Test
    public void testServiceView() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "k:\\Programme\\_WebDriver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/demo_10_menu/service");
        //driver.wait();

        Assert.assertEquals("DemoService", driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo_label")));
        
        WebElement elementButton = driver.findElement(By.id("demo_button"));
        Assert.assertEquals("Click me", elementButton.getText());
        
        WebElement elementLabel = driver.findElement(By.id("demo_label"));
        Assert.assertEquals("empty", elementLabel.getText());
        elementButton.click();
        Assert.assertEquals("Hallo", elementLabel.getText());
        
        WebElement elementTextField = driver.findElement(By.id("demo_textfield"));
        Assert.assertEquals("", elementTextField.getAttribute("value"));
        
        elementTextField.sendKeys("asdf");
        Assert.assertEquals("demo2", driver.findElement(By.id("demo_textfield")).getAttribute("value"));
        

    }
}
