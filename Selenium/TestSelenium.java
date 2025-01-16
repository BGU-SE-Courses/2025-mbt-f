import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;

public class TestSelenium {

        private static WebDriver driver;
        private static WebDriverWait wait;  // Add this line
    
        public static void main(String[] args) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-headless");
            
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize wait
        
        try {
            driver.get("http://localhost");
            Thread.sleep(5000); // Wait 5 seconds to see if it works
            login_func("noapatch", "Noa319123048#");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void login_func(String username, String password) {
        try {
            navigateToLoginPage();
            LoginUser(username, password);
            nevigate_To_My_Course();
            Thread.sleep(5000); // Wait to see the login result
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void navigateToLoginPage() throws InterruptedException {
        // Wait for and click the login link
        WebElement navigatetoLogin = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")));
        navigatetoLogin.click();
        Thread.sleep(1000);  // Small wait after click
    }

    public static void LoginUser(String username, String password) throws InterruptedException {
        // Wait for and fill in username
        WebElement usernameElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("username")));
        usernameElement.sendKeys(username);

        // Wait for and fill in password
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("password")));
        passwordElement.sendKeys(password);

        // Click login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("loginbtn")));
        loginButton.click();

        // Scroll down
        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        Thread.sleep(1000);  // Small wait after login
    }

    public static void nevigate_To_My_Course() throws InterruptedException{

        // Locate the toggle switch using its unique ID
        WebElement editModeButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("67893397ee12167893397e62d84-editingswitch")));
        
        // Click the toggle switch
        editModeButton.click();
        
        // Optional: Wait briefly to observe the action or verify state change
        wait.until(ExpectedConditions.attributeToBe(editModeButton, "checked", "true"));
        
        WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
        my_courses_button.click();
        Thread.sleep(1000);

        WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
        OS_button.click();
        Thread.sleep(1000);

        // WebElement edit_mode_button = wait.until(ExpectedConditions.elementToBeClickable(
        //     By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]")));
        // edit_mode_button.click();
        // Thread.sleep(1000);



    }
}

// 