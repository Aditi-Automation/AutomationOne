package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage
{
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h6[text()='Dashboard']")
    WebElement DashboardTitle;
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement Admin;
    @FindBy(xpath = "//span[text()='User Management ']")
    WebElement UM;
    @FindBy(xpath = "//a[text()='Users']")
    WebElement Users;
    @FindBy(xpath="//div[@class='oxd-form-row']//input[@class='oxd-input oxd-input--active']")
    WebElement UsersName;
    @FindBy(xpath ="//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[text()='Admin']")
    WebElement UserRole;

    @FindBy(xpath ="//p[@class='oxd-userdropdown-name']")
    WebElement UserIcon;
    @FindBy(xpath="//a[text()='Logout']")
    WebElement Logout;

    public boolean CheckDashboardTitle()
    {
        try
        {
           return (DashboardTitle.isDisplayed());
         }
        catch(Exception e)
        {
            return false;
        }
    }

    public void setUserIcon()
    {
        UserIcon.click();
    }

    public void setLogout()
    {
        Logout.click();
    }
    public void setAdmin()
    {
      Admin.click();
    }
    public void setUM()
    {
        UM.click();
    }
    public void setUsers()
    {
        Users.click();
    }
    public void setUsersName(String names)
    {
        UsersName.sendKeys(names);
    }
    public void setUserRole(String selection)
    {
        Select option=new Select(UserRole);
        option.selectByVisibleText(selection);
    }



}
