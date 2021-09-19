package JiraProject.UserStory3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class AddBook {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        Thread.sleep(2500);
        ArrayList<String> librarianEmails = new ArrayList<>(Arrays.asList("librarian46@library", "librarian47@library"));
        for (String eachEmail : librarianEmails) {
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(eachEmail);
            WebElement password = driver.findElement(By.id("inputPassword"));
            password.sendKeys("Sdet2022*");
            WebElement signIn = driver.findElement(By.cssSelector("button"));
            signIn.submit();
            Thread.sleep(2500);
            WebElement booksModule = driver.findElement(By.linkText("Books"));
            booksModule.click();
            WebElement booksBefore = driver.findElement(By.xpath("//div/table[@id='tbl_books']"));
            String beforeAdding = booksBefore.getText();
            WebElement addBook = driver.findElement(By.xpath("//a[@class=btn btn-lg btn-outline btn-primary btn-sm add_book_btn"));
            addBook.click();
            Thread.sleep(2500);
            WebElement bookName = driver.findElement(By.xpath("//form[@id='add_book_form']/div[1]/div/div[1]/div[1]/div/input"));
            bookName.sendKeys("Love");
            WebElement ISBN = driver.findElement(By.xpath("//input[@name='isbn']"));
            ISBN.sendKeys("12436789");
            WebElement addYear = driver.findElement(By.xpath("//input[@name='year']"));
            addYear.sendKeys("2020");
            WebElement addAuthor = driver.findElement(By.xpath("//input[@name='author']"));
            addAuthor.sendKeys("N.i.Ozen");
            WebElement addDescription = driver.findElement(By.id("description"));
            addDescription.sendKeys("This book is popular");
            WebElement bookCategory = driver.findElement(By.id("book_group_id"));
            bookCategory.sendKeys("Classic");
            WebElement saveChanges = driver.findElement(By.xpath("//button[@type='submit']"));
            saveChanges.submit();
            WebElement booksAddAfter = driver.findElement(By.xpath("//div[@class='dataTables_info']"));
            String afterAdd = booksAddAfter.getText();
            if (!beforeAdding.equals(afterAdd)) {
                System.out.println("Test passed");
                System.out.println("New Book added ");

            } else {
                System.out.println("Test failed");
                System.out.println("New Book not added");
                System.out.println(beforeAdding);
                System.out.println(afterAdd);
            }

            driver.quit();
        }
    }
}
/*
Given librarian is on the homePage
When librarian click Books module
And librarian click “+Add Book” button
When librarian enter BookName, ISBN, Year, Author, and Description
And librarian click save changes Then verify a new book is added
 */