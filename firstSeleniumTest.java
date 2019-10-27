package SELENIUMTEST;
import JavaCourse.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class firstSeleniumTest {
    @Test
    public void test(){
        String driverPath = "C:\\Users\\wasia\\IdeaProjects\\seleniumkurs\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\wasia\\OneDrive\\Desktop\\Java Selenium\\materiały do selenium WD\\Test.html");
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
        driver.manage().window().fullscreen();
         driver.findElement(By.id("newPage")).click();
         driver.close();//zamyka nowe okno na ktorym jest focus
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Znaleziono :  " + links.size());

        if (links.size()>0) {
            System.out.println("Linki istnieją");
        }else
            System.out.println("Btak linków");

        WebElement input = driver.findElement(By.id("fname"));
        input.sendKeys("Uda sie !!!");
        input.clear();
        input.sendKeys("Mam nadzieje");
        WebElement clckOnMeButton = driver.findElement(By.id("clickOnMe"));
        clckOnMeButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement input1 = driver.findElement(By.name("fname"));
        input1.sendKeys("Coś tam");
        System.out.println("Zawatość inputa "+ input1.getText());
        System.out.println("Zawatość inputa "+ input1.getAttribute("value"));
        WebElement label1 = driver.findElement(By.tagName("label"));
        System.out.println(label1.getText());
        WebElement checkbox = driver.findElement(By.xpath("//*[@type='checkbox']"));
        checkbox.click();
        WebElement imageTest = driver.findElement(By.id("smileImage"));
        System.out.println(imageTest.getSize().getHeight());
        System.out.println(imageTest.getAttribute("naturalHeight"));
        WebElement input3 = driver.findElement(By.id("fname"));
        input.sendKeys("Ziomek");
        if (input3.isEnabled()){
            System.out.println("Jest niedostepny");
        }else
            System.out.println("Jest dostępny");
            input3.sendKeys("Ziomek");


        //driver.quit(); //zamyka wszystkie okna
    }
}
