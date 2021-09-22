package LibraryCtProject.UserStory2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class NewUser {

    public static void main(String[] args)throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2500);
        ArrayList<String> librarianEmails = new ArrayList<>(Arrays.asList("librarian46@library", "librarian47@library"));
        for (String eachEmail : librarianEmails  ){
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(eachEmail);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            WebElement signIn = driver.findElement(By.cssSelector("button"));
            signIn.submit();
            Thread.sleep(2500);
            WebElement usersClick = driver.findElement(By.linkText("Users"));
            usersClick.click();
            Thread.sleep(2500);
            WebElement beforeNumberOfUsers=driver.findElement(By.id("tbl_users_info"));
            WebElement addUser = driver.findElement(By.linkText("Add User"));
            addUser.click();
            Thread.sleep(2500);
            WebElement fullName = driver.findElement(By.xpath("//input[@name='full_name']"));
            fullName.sendKeys("NesLihan Ince");
            Thread.sleep(2500);
            WebElement addPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            addPassword.sendKeys("Nes123");
            Thread.sleep(2500);
            WebElement addEmail = driver.findElement(By.xpath("//input[@name='email']"));
            addEmail.sendKeys("Neslihan@gmail.com");
            Thread.sleep(2500);
            WebElement addAddress = driver.findElement(By.id("address"));
            addAddress.sendKeys("706 galleria");
            Thread.sleep(2500);
            WebElement saveChanges = driver.findElement(By.xpath("//button[@type='submit']"));
            saveChanges.click();
            Thread.sleep(2500);
            WebElement afterNumberOfUsers = driver.findElement(By.id("bl_users_info"));
            if (!beforeNumberOfUsers.getText().equals(afterNumberOfUsers.getText())){
                System.out.println("Test passed");
                System.out.println("Adding new user");
            }else {
                System.out.println("Test failed");
                System.out.println(beforeNumberOfUsers.getText());
                System.out.println(afterNumberOfUsers.getText());
            }
            driver.quit();
        }
    }
}
/*
Given librarian is on the homePage
When librarian click Users module
And librarian click “+Add User” button
When librarian enter full name, password, email and address
And librarian click save changes Then verify a new user is created

 */