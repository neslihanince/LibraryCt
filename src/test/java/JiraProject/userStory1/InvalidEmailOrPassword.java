package JiraProject.userStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class InvalidEmailOrPassword {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2500);
        driver.get(driver.getCurrentUrl());
        String email = "Neslihanince@gmail.com";
        WebElement emailBox = driver.findElement(By.id("inputEmail"));
        emailBox.sendKeys(email);
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        WebElement signIn = driver.findElement(By.xpath("//button[@class=btn btn-lg btn-primary btn-block"));
        signIn.click();
        Thread.sleep(2500);
        WebElement invalid = driver.findElement(By.xpath("//div[@class=alert alert-danger"));
        System.out.println("invalid.getText() = " + invalid.getText());
        if (invalid.getText().equals("Soory, Wrong Email or Password")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }
        driver.quit();
    }
}
/*
Given user is on the loginPage
When user enters invalid email address or password
And student click sign in button
Then verify the error message “Sorry, Wrong Email or Password”
 */