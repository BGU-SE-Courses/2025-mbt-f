package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

        try {
            driver.get("http://localhost");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
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

    @And("Teacher navigates to course name")
    public void teacher_navigates_to_course_name() {
        // Go to my courses
        WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
        my_courses_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Go to the specific course
        WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
        OS_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Teacher deletes quiz number")
    public void teacher_deletes_quiz_number() {
        //click on the edit mode
        WebElement edit_node_toggle = driver.findElement(By.className("custom-control"));
        edit_node_toggle.click();
        // scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll_down = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll_down);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the 3 dots button
        WebElement three_dots_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        three_dots_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Click on the delete quiz
        WebElement delete_the_quiz_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a[8]")));
        delete_the_quiz_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Click on the red delete button and ensure that the quiz is deletes
        WebElement delete_quiz = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'btn') and contains(text(), 'Delete')]")));

        // Use JavaScript to click the button
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", delete_quiz);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("the quiz should be successfully deleted")
    public void the_quiz_should_be_successfully_deleted() {
        try {
            // Check multiple elements to verify deletion
            boolean threeDotButtonGone = driver.findElements(
                    By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")
            ).isEmpty();

            // Comprehensive verification
            if (!threeDotButtonGone) {
                throw new AssertionError("Quiz deletion failed: Three dot menu still present");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up - close browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

 @Given("Student is on Home Page")
    public void student_is_on_home_page() {
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Navigate to the home page
        driver.get("http://localhost");
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Student is logged in with {string} and {string}")
    public void student_is_logged_in_with_and(String string, String string2) {
        this.name = string;
        this.password = string2;
        //go the the login page
        WebElement navigatetoLogin = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
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

    @When("Student navigates to my courses and course")
    public void student_navigates_to_my_courses_and_course() {
        // Go to my courses
        WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
        my_courses_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Go to the specific course
        WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
        OS_button.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("Student check grade to the quiz")
    public void student_check_grade_to_the_quiz() {
        // Navigate to the quiz grades
        WebElement enter_quiz = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[4]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")));
        enter_quiz.click();
        try{
            Thread.sleep(2000);
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("the student can see the grade")
    public void the_student_can_see_the_grade() {
        try {
            // Check multiple elements to verify deletion
            boolean grade_show = driver.findElements(
                    By.xpath("/html[1]/body[1]/div[2]/div[4]/div[1]/div[2]/div[1]/section[1]/div[2]/div[3]/h3[1]")
            ).isEmpty();

            // Comprehensive verification
            if (grade_show) {
                throw new AssertionError("quiz grade showing failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up - close browser
            if (driver != null) {
                driver.quit();
            }
        }

}
}



