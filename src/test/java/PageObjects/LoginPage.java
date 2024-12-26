package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public void setUsername(String name) {
       username.sendKeys(name);
    }

    public void setPassword(String name)
    {
        password.sendKeys(name);
    }

    public void setSubmit() {
        submit.click();
    }
}
