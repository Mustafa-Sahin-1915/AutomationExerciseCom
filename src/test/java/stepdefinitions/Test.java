package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class Test {

    @org.junit.Test
    public void method(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.automationexercise.com/contact_us");
        String userHomePath = System.getProperty("user.home");
        String picturesPath = userHomePath+"\\OneDrive\\Pictures";//for one drive
        String fileName = "sample.png";
        String uploadedFilePath = picturesPath+"\\"+fileName;
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='name']"));
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='email']"));
        WebElement subject = driver.findElement(By.xpath("//input[@data-qa='subject']"));
        WebElement upload = driver.findElement(By.xpath("//input[@name='upload_file']"));
        WebElement message = driver.findElement(By.id("message"));
        name.sendKeys("A");
        email.sendKeys("aa@gmail.com");
        subject.sendKeys("bbb");
        message.sendKeys("DDDDDD");
        upload.sendKeys(uploadedFilePath);

        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();
        driver.switchTo().alert().accept();
        String statusMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).getText();
        Assert.assertEquals(statusMessage, "Success! Your details have been submitted successfully.");
        driver.findElement(By.xpath("//i[@class='fa fa-home']")).click();


    }
}
