package cucumber.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.WebDriver;

public class LoginSteps implements En {

    WebDriver driver;

    public LoginSteps() {
        Given("User navigates to the application website", () -> {
//            this.driver  = new FirefoxDriver();
//            this.driver.manage().window().maximize();
//            this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//            // Write code here that turns the phrase above into concrete actions
//            driver.get("http://localhost:8080/home");
        });
        Given("User clicks on login button", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        Given("User enters a valid username", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        Given("User enters a valid password", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
        });
        When("User clicks on the login button", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
        });
        Then("User should be taken to the default page", () -> {
            // Write code here that turns the phrase above into concrete actions
//            throw new io.cucumber.java8.PendingException();
        });
    }
}
