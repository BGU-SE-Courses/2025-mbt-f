package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;
    private final static String path = "C:\\Users\\User\\Desktop\\ass_4\\2025-mbt-f\\Selenium\\chromedriver.exe";
    private String name;
    private String password;

    @Given("Teacher is on Home Page")
    public void teacher_is_on_home_page() {
        //set the driver with the path to the chromeDriver and go to localhost web
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try{
            driver.get("http://localhost");
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    @When("Teacher is logged in with {string} and {string}")
    public void teacher_is_logged_in_with_and(String string, String string2) {
        this.name = string;
        this.password = string2;
        //go the the login page
        WebElement navigatetoLogin = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")));
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        navigatetoLogin.click();
        // Fill the user name in the form
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        usernameElement.sendKeys(name);
        // Fill the password in the form
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        passwordElement.sendKeys(password);
        // Click in the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbtn")));
        loginButton.click();
    }

     @When("Teacher navigates to course name")
     public void teacher_navigates_to_course_name() {
         // Go to my courses
         WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
         my_courses_button.click();
                 try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
         // Go to the specific course
         WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
         OS_button.click();
         OS_button.click();
                 try{
                Thread.sleep(5000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
         // Click on the edit toggle
         WebElement edit_node_toggle = driver.findElement(By.className("custom-control"));
         edit_node_toggle.click();
     }

     @When("Teacher deletes quiz number")
     public void teacher_deletes_quiz_number() {
         // Scroll down to the 3 dots button
         JavascriptExecutor js = (JavascriptExecutor) driver;
         WebElement scroll_down = wait.until(ExpectedConditions.presenceOfElementLocated(
                 By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
         js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll_down);

         // Click on the 3 dots button
         WebElement three_dots_button = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
         three_dots_button.click();
         // Click on the delete quiz
         WebElement delete_the_quiz_button = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a[8]")));
         delete_the_quiz_button.click();
         // Click on the red delete button and ensure that the quiz is deletes
         WebElement delete_quiz = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//button[contains(@class, 'btn') and contains(text(), 'Delete')]")));
         js.executeScript("arguments[0].click();", delete_quiz);
     }

    @Then("the quiz should be successfully deleted")
    public void the_quiz_should_be_successfully_deleted() {
         //check that the quiz is delete
         boolean isQuizDeleted = driver.findElements(By.xpath("//div[contains(@class, 'quiz-number-")).isEmpty();
         if (!isQuizDeleted) {
             throw new AssertionError("Quiz was not deleted successfully.");
         }
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
