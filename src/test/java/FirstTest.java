import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Random;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        Random random = new Random();
        int emailSize = random.nextInt(10 - 5) + 5;//Выбираем случайную длину Email.
        FirstPage page = new FirstPage(driver);//Создаем экземпляр страницы, чтобы было проще писать
        String randomEmail = page.randomString(emailSize) + "+wpt@wriketask.qaa";
        page.login.click();
        page.sendEmail(randomEmail);
        assertTrue(page.isWorkingSubmit());
        ResendPage resendPage = page.submit();
        driver.getCurrentUrl();
        //проверяем открылось ли то что, что нам нужно
        assertTrue(resendPage.isWorking());
        resendPage.fillForm(resendPage.getAllSwitches());
        assertTrue(resendPage.surveyFormSubmitted());
        assertEquals("https://twitter.com/wrike", resendPage.getTwitterLink());
        assertEquals("/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter", resendPage.getTwitterPhotoLink());
    }

}
