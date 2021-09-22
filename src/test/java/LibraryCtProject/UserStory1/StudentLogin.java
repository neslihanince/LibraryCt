package LibraryCtProject.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2500);
        if (driver.getTitle().equals("Login-Library")) {
            System.out.println("Pass");
        } else {
            System.out.println("don't pass");
        }
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("student54@library", "student55@library", "student56@library"));
        String password = "Sdet2022*";
        for (String eachEmail : userNames) {
            String currentUrl = driver.getCurrentUrl();
            String expectedUrl = "https://library2.cybertekschool.com/login.html";
            if (currentUrl.equals(expectedUrl)) {
                System.out.println("Url is match ");
                System.out.println("Test passed");
            } else {
                System.out.println("Urls is not match");
                System.out.println("Test failed");
            }
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(eachEmail);
            Thread.sleep(2500);
            WebElement pass = driver.findElement(By.id("inputPassword"));
            pass.sendKeys(password);
            Thread.sleep(2500);
            WebElement signIn = driver.findElement(By.tagName("button"));
            signIn.submit();
            Thread.sleep(2500);
            WebElement module1 = driver.findElement(By.linkText("Books"));
            WebElement module2 = driver.findElement(By.linkText("Browing Books"));
            ArrayList<String> actualM = new ArrayList<>(Arrays.asList(module1.getText(), module2.getText()));
            ArrayList<String> expectedM = new ArrayList<>(Arrays.asList("Browing Books","Books"));
            if (actualM.equals(expectedM)){
                System.out.println("Results are match");
                System.out.println("Test passed ");
                System.out.println("System has Browing Books and Books");
            }else {
                System.out.println("Results are not match");
                System.out.println("Test failed");
            }
            driver.quit();
        }}}
/*
Given student is on the loginPage
Then verify that the URL is           “https://library2.cybertekschool.com/login.html”
When student enters valid email address and password
And student click sign in button
Then verify that there are 2 models on the page...
 */