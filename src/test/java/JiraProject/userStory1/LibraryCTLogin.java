package JiraProject.userStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LibraryCTLogin {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2500);
        String expectedTitle = driver.getTitle();
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title match");
        }else{
            System.out.println("Title not match");
        }
        Thread.sleep(2500);
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys("librarian46@library");
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("Sdet2022*");
        WebElement signIn = driver.findElement(By.cssSelector("button"));
        signIn.click();
        Thread.sleep(2500);
        List<WebElement> actualModules = driver.findElements(By.className("title"));
        if (actualModules.size() ==3 ){
            System.out.println("User is passed");
            System.out.println("actualModules.size() = " + actualModules.size());
        }else{
            System.out.println("User is not passed.");
        }
        Thread.sleep(2500);
        driver.quit();
    }
    }
 /*
 Given librarian is on the loginPage
 Then verify that the title is “Login - Library”
 When librarian enters valid email address and password
 And librarian click sign in button
 Then verify that there are3 model son the page
  */
