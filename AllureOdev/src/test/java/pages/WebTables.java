package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import driver.DriverFactory;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class WebTables extends BasePage{

    public SelenideElement addbtn=$("#addNewRecordButton");
    public SelenideElement firstNameValue=$("input#firstName");
    public SelenideElement lastNameValue=$("input#lastName");
    public SelenideElement emailValue=
            $("div [class=\"col-md-9 col-sm-12\"]>[placeholder=\"name@example.com\"]");
    public SelenideElement ageValue=$("input[id=\"age\"][placeholder=\"Age\"]");
    public SelenideElement salaryValue=$("div[class=\"col-md-9 col-sm-12\"]>[id=\"salary\"]");
    public SelenideElement departmentValue=$("#department");
    public SelenideElement submit=$("#submit");
    public SelenideElement editBtn=$("div[class=\"action-buttons\"]>span[id=\"edit-record-4\"]");
    public SelenideElement editFirstname=
            $("form[id=\"userForm\"]>div input[id=\"firstName\"][placeholder=\"First Name\"]");
    public SelenideElement editSubmitBtn=
            $("form[id=\"userForm\"]>div button[id=\"submit\"][type=\"submit\"]");
    public SelenideElement editedRow =
            $("div[class=\"rt-tr-group\"]:nth-child(4) div[class=\"rt-td\"]:nth-child(1)");

    public WebTables(String pageUrl) {
        super(pageUrl);
    }

    public void fillTheForm(String firstName, String lastName, String email, String age, String salary, String department){
        firstNameValue.setValue(firstName);
        lastNameValue.setValue(lastName);
        emailValue.setValue(email);
        ageValue.setValue(String.valueOf(age));
        salaryValue.setValue(String.valueOf(salary));
        departmentValue.setValue(department);
        submit.click();
    }

    public void clickEditBtn(){
        new Actions(DriverFactory.currentDriver()).scrollByAmount(0, 300).perform();
        editBtn.should(Condition.clickable, Duration.ofSeconds(10));
        editBtn.click();
    }

    public void editName(String firstNameValue){
        editFirstname.should(Condition.visible , Duration.ofSeconds(10));
        editFirstname.clear();
        editFirstname.setValue(firstNameValue);
        editSubmitBtn.click();
    }
}
