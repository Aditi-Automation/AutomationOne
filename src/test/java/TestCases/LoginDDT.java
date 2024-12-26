package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT extends TestBase1 {
        @Test(dataProvider = "login")
        public void Loginddt (String name, String password, String exp)
        {
            logger.info("***start loginDDT***");
            LoginPage Lp = new LoginPage(driver);
            Lp.setUsername(name);
            Lp.setPassword(password);
            Lp.setSubmit();

            HomePage Hp = new HomePage(driver);
            boolean targetPage = Hp.CheckDashboardTitle();

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    Hp.setUserIcon();
                    Hp.setLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    Hp.setUserIcon();
                    Hp.setLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }



}

    @DataProvider(name="login")
    public Object[][] getData()
    {
        return new Object[][]

                { {"Admin","admin123","Valid"},
        {"Admin,","admin153","Invalid"},
        {"aditi","admin123","Invalid"}};
    }
}
