import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ResendPage extends PageObject {

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")
    protected WebElement resendButton;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[3]/button/span")
    public WebElement additional;

    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")
    public WebElement submitResult;

    @FindBy(xpath = "//*[@id=\"twitter\"]/path")
    public WebElement twitterButton;

    @FindBy(className = "survey-form")
    public WebElement surveyForm;

    public ResendPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> elementsSwitch = surveyForm.findElements(By.xpath("//button[@type = 'switch_button']"));

    public List<WebElement> getAllSwitches() {
        return elementsSwitch;
    }

    boolean isWorking() {
        return submitResult.isDisplayed() && surveyForm.isDisplayed();
    }


    public void fillForm(List<WebElement> buttons) {
        int size = elementsSwitch.size();
        FirstPage pageHelp = new FirstPage(driver);
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        int int1 = r1.nextInt(2 - 0);
        buttons.get(int1).click();
        int int2 = r2.nextInt(7 - 3);
        buttons.get(int2).click();
        int int3 = r3.nextInt(10 - 8);
        if (int3 != 10) {
            buttons.get(int3).click();
        } else {
            additional.sendKeys(pageHelp.randomString(10 - 5));
        }
        submitResult.click();
    }

    // при сдаче данных, становится это поле неактивным
    boolean surveyFormSubmitted() {
        return !surveyForm.isDisplayed();
    }

    String getTwitterLink() {
        return twitterButton.getAttribute("href");
    }

    String getTwitterPhotoLink() {
        return twitterButton.getAttribute("xlink:href");
    }

}
