package bot;

import bot.models.FormData;
import bot.models.FormData.CompanyInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Bot {
    public static void main(String[] args) {
        System.out.println(" Java bot started.");

        FormData formData = GPTFieldFiller.loadFormData("gpt_output.json");
        if (formData == null) {
            System.out.println(" Failed to load form data.");
            return;
        }

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kanch\\OneDrive\\Desktop\\Auttomation\\bot\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            driver.get("https://www.naukri.com/mnjuser/login");

            // Login agjust selector on own
            WebElement email = driver.findElement(By.id("usernameField"));
            WebElement password = driver.findElement(By.id("passwordField"));
            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

            email.sendKeys(formData.getEmail());
            String passwordValue = System.getenv("NAUKRI_PASS");
            if (passwordValue == null || passwordValue.isEmpty()) {
            System.out.println(" Naukri password not set in environment variable.");
                return;
            }
            password.sendKeys(passwordValue);
            // load securely
            loginBtn.click();

            Thread.sleep(5000); // wait for login

            // Navigate to a job apply 
            driver.get("https://www.naukri.com/job-listings-ios-developer-at-an-e-commerce-unicorn-recruito-bengaluru-0-to-2-years-170625013142?src=drecomm_dashboard_apply");


            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("apply-button")
            ));

            applyButton.click();

            Thread.sleep(3000);

            // Example form field fill 
            WebElement aboutField = driver.findElement(By.name("aboutYourself"));
            aboutField.sendKeys(formData.getAboutYou());

            WebElement resumeUpload = driver.findElement(By.xpath("//input[@type='file']"));
            resumeUpload.sendKeys(formData.getResumePath());

            // Submit application
            WebElement finalSubmit = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            finalSubmit.click();

            System.out.println("✅ Applied to job successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
