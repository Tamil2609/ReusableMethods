package selenium;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

    public class Reusable_Methods
    {
        static WebDriver driver;
        static String url1 = "https://demoqa.com/alerts";
        static String xpath = "//*[@id=\"confirmButton\"]";
        static String output = "text-success";
        static String url2="https://www.linkedin.com/login";
        static String userId="username";
        static String pwd="password";
        static String signIn="//button[text()='Sign in']";
        static void launching()
        {
            System.setProperty("webdriver.chrome.driver", "D:\\Browserdrivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        static void validateUrl(WebDriver driver)
        {
            Reusable_Methods.driver.get(url1);
            List<WebElement> linksList = Reusable_Methods.driver.findElements(By.tagName("a"));
            System.out.println(" link count:" + linksList.size());
            for (int count = 0; count < linksList.size(); count++)
            {
                System.out.println("Links on page are:" + linksList.get(count).getAttribute("href"));
                System.out.println("Link Name :" + linksList.get(count).getText());
            }
        }
        static void validate_dialogbox_enabled(WebDriver driver)
        {

            WebElement element = Reusable_Methods.driver.findElement(By.xpath(xpath));
            element.click();
            //Thread.sleep(2000);
            Alert alert = Reusable_Methods.driver.switchTo().alert();
            String message = alert.getText();
            System.out.println("content in alert box:" + message);
            alert.accept();
            System.out.println("Confirmation message:" + driver.findElement(By.className(output)).getText());
            if (element.isEnabled())
            {
                System.out.println("Confirm Dialog box is ok.Return:" + element.isEnabled());
            } else {
                System.out.println("Confirm Dialog box is cancel");
            }

        }
        static void validate_dialogbox_disable(WebDriver driver)
        {
            WebElement element = Reusable_Methods.driver.findElement(By.xpath(xpath));
            element.click();
            //Thread.sleep(2000);
            Alert alert = Reusable_Methods.driver.switchTo().alert();
            String message = alert.getText();
            System.out.println("content in alert box:" + message);
            alert.dismiss();
            System.out.println("confirmation message:" + driver.findElement(By.className(output)).getText());
            if (element.isEnabled())
            {
                System.out.println("Confirm Dialog box is cancel.Return:" + element.isEnabled());
            } else {
                System.out.println("confirm dialog box is not disabled");
            }
        }
        static void Login_LinkedIn(WebDriver driver) throws InterruptedException
        {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url2);
            WebElement username = driver.findElement(By.id(userId));
            System.out.println("Is Displayed "+ username.isDisplayed());
            driver.findElement(By.id(userId)).sendKeys("priyatamil2631@gmail.com");
            driver.findElement(By.id(pwd)).sendKeys("priyarosh2731");
            driver.findElement(By.xpath(signIn)).click();
            Thread.sleep(2000);


        }
    }

