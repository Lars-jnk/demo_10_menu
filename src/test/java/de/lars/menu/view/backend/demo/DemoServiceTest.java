/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

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
    public void testServiceView() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "k:\\Programme\\_WebDriver\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://localhost:8080/demo_10_menu/service");

        Assert.assertEquals("DemoService", driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ServiceView.ID_LABEL)));

        Assert.assertEquals("", getTextfield(driver).getAttribute("value"));
        Assert.assertEquals("Text eingeben", getTextfield(driver).getText());

        Assert.assertEquals("Click me", getButton(driver).getText());
        Assert.assertEquals("empty", getLabel(driver).getText());
        getButton(driver).click();
        Assert.assertEquals("Hallo", getLabel(driver).getText());

        writeInTextField(driver, "asdf");
        getButton(driver).click();
        Assert.assertEquals("Hallo asdf", getLabel(driver).getText());
    }

    private WebElement getButton(WebDriver driver) {
        return driver.findElement(By.id(ServiceView.ID_BUTTON));
    }

    private WebElement getLabel(WebDriver driver) {
        return driver.findElement(By.id(ServiceView.ID_LABEL));
    }

    private WebElement getTextfield(WebDriver driver) {
        return driver.findElement(By.id(ServiceView.ID_TEXTFIELD));
    }

    private void writeInTextField(WebDriver driver, String text) {
        getTextfield(driver).findElement(By.cssSelector("input")).sendKeys(text);
    }
}
