


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static stepdefinitions.Hooks.getDriver;
import static stepdefinitions.Hooks.getWait;
import org.junit.jupiter.api.Assertions;

public class QuizManagementSteps {
    private final WebDriver driver = getDriver();
    private final WebDriverWait wait = getWait();

    @Given("Teacher is on Home Page")
    public void teacherIsOnHomePage() throws InterruptedException {
        driver.get("http://localhost");
        Thread.sleep(5000);
    }

    @When("Teacher is logged in with username and password")
    public void teacherIsLoggedIn() throws InterruptedException {
        // Login link
        WebElement navigatetoLogin = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")));
        navigatetoLogin.click();
        Thread.sleep(1000);

        // Fill login form
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("username")));
        usernameElement.sendKeys("noapatch");

        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("password")));
        passwordElement.sendKeys("Noa319123048#");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("loginbtn")));
        loginButton.click();
        Thread.sleep(1000);
    }

    @When("Teacher navigates to course number {string}")
    public void teacherNavigatesToCourse(String courseNumber) throws InterruptedException {
        // Navigate to My Courses
        WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
        my_courses_button.click();
        Thread.sleep(1000);
        
        // Click OS course
        WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
        OS_button.click();
        Thread.sleep(1000);

        // Enable edit mode
        WebElement edit_node_toggle = driver.findElement(By.className("custom-control"));
        edit_node_toggle.click();
    }

    @When("Teacher deletes quiz number {string}")
    public void teacherDeletesQuiz(String quizNumber) throws InterruptedException {
        // Scroll to quiz
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll_down = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll_down);

        // Click three dots
        WebElement three_dots_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        three_dots_button.click();
        Thread.sleep(1000);

        // Click delete option
        WebElement delete_the_quiz_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a[8]")));
        delete_the_quiz_button.click();
        Thread.sleep(1000);

        // Confirm deletion
        WebElement delete_quiz = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(@class, 'btn') and contains(text(), 'Delete')]")));
        js.executeScript("arguments[0].click();", delete_quiz);
    }

    @Then("the quiz should be successfully deleted")
    public void quizShouldBeDeleted() throws InterruptedException {
        Thread.sleep(10000);
        // Add verification if needed
        // For example:
        // boolean quizExists = driver.findElements(By.id("quiz-element-id")).size() > 0;
        // Assertions.assertFalse(quizExists, "Quiz should not exist after deletion");
    }
}