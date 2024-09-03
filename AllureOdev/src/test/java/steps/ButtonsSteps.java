package steps;

import com.codeborne.selenide.Condition;
import common.PageFactory;
import common.PageManager;
import driver.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.BaseTest;

import java.time.Duration;

@Feature("Click Me Button Functionally")
public class ButtonsSteps extends BaseTest {
    PageManager pageManager = new PageManager();

    @Before
    @Step("Initialize the Buttons page")
    public void before() {
        PageFactory.buildButtons();
    }

    @Given("Buttons page opens")
    @Description("Open the Buttons page and verify that it is loaded correctly")
    @Step("Open Buttons page")
    public void openButtonsPage() {
        pageManager.buttons.button.click();
    }

    @When("Click the Click me button")
    @Description("Click the 'Click Me' button and perform the necessary action")
    @Step("Click 'the Click Me' button")
    public void clickClickMeButton() {
        pageManager.buttons.clickToClickMe();
        attachScreenshot("Click Me");
    }

    @Then("The dynamic message is displayed")
    @Description("Check if the dynamic message appears after clicking the button")
    @Step("Verify the dynamic message")
    public void dynamicClickIsDisplayed() {
        pageManager.buttons.dynamicMessage.should(Condition.appear, Duration.ofSeconds(10));
        Assertions.assertThat(pageManager.buttons.dynamicMessage.getText()).isEqualTo("You have done a dynamic click");
    }

    @Attachment(value = "{0}", type = "image/png")
    public void attachScreenshot(String name) {
        ((TakesScreenshot) DriverFactory.currentDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
