package TestCases;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.TestBase1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCae1_login extends TestBase1
{
        @Test(groups = "Sanity")
        public void login ()
        {
            logger.info("****Staring login testcase***");
            try {
                LoginPage Lp = new LoginPage(driver);

                logger.info("***add name***");
                Lp.setUsername(p.getProperty("name"));

                logger.info("*** add password");
                Lp.setPassword(p.getProperty("password"));
                Lp.setSubmit();


                HomePage hp =new HomePage(driver);
                boolean targetPage = hp.CheckDashboardTitle();
                if(targetPage==true)
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);

                }
            }
            catch(Exception e)
            {
                logger.error("****test failed***");
                logger.debug(" Debug_logs");
                Assert.fail();
            }

    }

    }



