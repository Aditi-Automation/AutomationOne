package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase1;
import org.testng.annotations.Test;

public class TestCase2_HomePage extends TestBase1
{
    @Test
    public void openHomePage()
    {
        logger.info("***start login***");
         LoginPage Lpage = new LoginPage(driver);
            Lpage.setUsername(p.getProperty("name"));
            Lpage.setPassword(p.getProperty("password"));
            Lpage.setSubmit();

            logger.info("***start homepage***");
        HomePage Hp=new HomePage(driver);
        Hp.setAdmin();
        Hp.setUM();
        Hp.setUsers();
        Hp.setUsersName(p.getProperty("uname"));
        //Hp.setUserRole(p.getProperty("selectOption"));
    }
}
