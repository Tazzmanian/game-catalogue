package cucumber.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps implements En {
    WebDriver driver;

    public GoogleSearchSteps() {
        Given("browser is open", () -> {
            System.setProperty("webdriver.edge.driver", "D:/repos/game-catalogue/src/test/resources/drivers/msedgedriver.exe");
            this.driver  = new EdgeDriver();
            this.driver.manage().window().maximize();
            this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            this.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            // Write code here that turns the phrase above into concrete actions
            System.out.println("step 1");
        });
        And("user is on google page", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("step 2");
            driver.navigate().to("https://google.com");
        });
        When("user enters a text in search box", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("step 3");
            driver.findElement(By.name("q")).sendKeys("Automation Step by Steps");
        });
        And("hit enter", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("step 4");
            driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        });
        Then("user is navigated to search results", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("step 5");
            driver.getPageSource().contains("Online Courses");
            driver.close();
            driver.quit();
        });
    }
}
