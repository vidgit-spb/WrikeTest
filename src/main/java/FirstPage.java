import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;

public class FirstPage extends PageObject {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();


    public FirstPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
    public WebElement login;

    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[1]/input")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"modal-pro\"]/form/label[2]/button")
    public WebElement submitButton;


    public boolean isWorkingLogin() {
        return login.isDisplayed() && login.isEnabled();
    }

    public boolean isWorkingEmail() {
        return email.isDisplayed() && email.isEnabled();
    }

    public boolean isWorkingSubmit() {
        return submitButton.isDisplayed() && submitButton.isEnabled();
    }


    public void sendEmail(String email) {

        this.email.sendKeys(email);
    }


    public String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public ResendPage submit() {
        submitButton.click();
        return new ResendPage(driver);
    }


}
