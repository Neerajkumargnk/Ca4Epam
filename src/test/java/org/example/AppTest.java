package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class AppTest{
    ChromeDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setUpDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        Thread.sleep(15000);

    }

    @Test
    void dropdown1() {
        WebElement DropDown = driver.findElement(By.id("dropdowm-menu-1"));
        Select dropdown = new Select(DropDown);
        dropdown.selectByVisibleText("Python");
    }
    @Test
    void dropdown2() {
        WebElement DropDown = driver.findElement(By.id("dropdowm-menu-2"));
        Select dropdown = new Select(DropDown);
        dropdown.selectByVisibleText("TestNG");
    }
    @Test
    void dropdown3() {
        WebElement DropDown = driver.findElement(By.id("dropdowm-menu-3"));
        Select dropdown = new Select(DropDown);
        dropdown.selectByVisibleText("JavaScript");
    }
    @Test
    void checkbox1() {
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[2]/input")).click();
    }
    @Test
    void checkbox2() {
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/label[3]/input")).click();
    }

    @Test
    void radioButton() {
        driver.findElement(By.xpath("  //*[@id=\"radio-buttons\"]/input[3]")).click();
}
    @AfterClass
    void closeDriver(){

        driver.close();
    }
}
