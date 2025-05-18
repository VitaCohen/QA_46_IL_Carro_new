package pages;

import dto.RegistrationBodyDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//h2[@class='message']")
    WebElement popUpMessage;

    @FindBy(xpath = "//div[@class='error']")
    WebElement errorMessage;

    public void typeLoginForm(RegistrationBodyDto user) {
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());


    }

    public void clickBtnYalla() {
        clickWait(btnYalla, 3);
    }

    public void clickBtnYallaWOWait(){
        btnYalla.click();
    }

    public  boolean isPopMessagePresent(String text){
        return validateTextInElementWait(popUpMessage,
                text, 5);
    }

    public boolean validateErroeMessage(String text){
        return validateTextInElementWait(errorMessage, text, 3);
    }

}
