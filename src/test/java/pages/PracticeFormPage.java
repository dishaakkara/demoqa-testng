package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormPage {
    WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement email;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement phone;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement address;

    @FindBy(xpath = "//label[text()='Male']")
    WebElement male;

    @FindBy(xpath = "//label[text()='Female']")
    WebElement female;

    @FindBy(xpath = "//label[text()='Other']")
    WebElement other;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    WebElement successTitle;

    public void fillForm(String fName, String lName, String mail, String gender, String mobile, String addr) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(mail);

        selectGender(gender);

        phone.sendKeys(mobile);
        address.sendKeys(addr);
    }
    public void submitForm() {
        submitBtn.click();
    }

    public String getSuccessMessage() {
        return successTitle.getText();
    }
    public String getPhoneFieldBorderColor() {
        return phone.getCssValue("border-color");
    }
    public void selectGender(String gender) {
        WebElement genderElement;

        if (gender.equalsIgnoreCase("Male")) {
            genderElement = male;
        } else if (gender.equalsIgnoreCase("Female")) {
            genderElement = female;
        } else {
            genderElement = other;
        }

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", genderElement);

        // JS click to bypass iframe overlay
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", genderElement);
    }
}
