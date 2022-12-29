package cucumber.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps implements En {

    WebDriver driver;

    public LoginSteps() {
        Given("User navigates to the application website", () -> {
            System.setProperty("webdriver.edge.driver", "D:/repos/game-catalogue/src/test/resources/drivers/msedgedriver.exe");
            this.driver  = new EdgeDriver();
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.get("http://localhost:8080/login");
        });
        And("User enters a valid username", () -> {
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.id("username")).sendKeys("admin1");
        });
        And("User enters a valid password", () -> {
            // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.id("password")).sendKeys("test");
        });
        When("User clicks on the login button", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
            driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
        });
        Then("User should be taken to the default page", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
            driver.getPageSource().contains("Whitelabel Error Page");
            driver.close();
            driver.quit();
        });
    }
}
