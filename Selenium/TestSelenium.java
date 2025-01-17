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
            wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        
        try {
            driver.get("http://localhost");
            Thread.sleep(5000); 
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
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void navigateToLoginPage() throws InterruptedException {
        // Wait for and click the login link
        WebElement navigatetoLogin = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/div[1]/div[1]/span[1]/a[1]")));
        navigatetoLogin.click();
        Thread.sleep(1000); 
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
        Thread.sleep(1000); 
    }

    public static void nevigate_To_My_Course() throws InterruptedException{

        WebElement my_courses_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[1]/nav[1]/ul[1]/li[3]/a[1]")));
        my_courses_button.click();
        Thread.sleep(1000);
        
        WebElement OS_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[2]/div[1]/section[1]/div[1]/aside[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[3]/span[2]")));
        OS_button.click();
        Thread.sleep(1000);

        WebElement edit_node_toggle = driver.findElement(By.className("custom-control"));
        edit_node_toggle.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll_down = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", scroll_down);

        WebElement three_dots_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")));
        three_dots_button.click();
        Thread.sleep(1000);

        WebElement delete_the_quiz_button = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("/html[1]/body[1]/div[4]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[2]/ul[1]/li[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/a[8]")));
        delete_the_quiz_button.click();
        Thread.sleep(1000);

        // WebElement delete_quiz = wait.until(ExpectedConditions.elementToBeClickable(
        //     By.xpath("/html[1]/body[1]/div[7]/div[2]/div[1]/div[1]/div[3]/button[2]")));
        // delete_quiz.click();
        // Thread.sleep(5000);

        WebElement delete_quiz = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(@class, 'btn') and contains(text(), 'Delete')]")));
        
        // Use JavaScript to click the button
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", delete_quiz);
        Thread.sleep(10000);



    }
}

// 