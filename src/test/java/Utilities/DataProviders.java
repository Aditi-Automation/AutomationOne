package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders
{
    @DataProvider(name="login")
    public Object[][] getData()
    {
        return new Object[][]
        {{"Admin","admin123"}, {"admin,","admin123"}, {"Admin","admin345"}};
    }
}
