package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;

public class ExtentManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
        public ExtentReports extent;
        //private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
        public ExtentTest test;
        String repname;


        public void onStart(ITestContext testContext)
        {
                // File name with timestamp for unique report generation
             SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.ss");
             java.util.Date dt= new java.util.Date();
             String timestamp=df.format(dt);
            repname="Test-report-" +timestamp+ ".html";


                // Initialize the ExtentSparkReporter
                sparkReporter = new ExtentSparkReporter(".\\Reports\\" + repname);
                sparkReporter.config().setTheme(Theme.STANDARD);
                sparkReporter.config().setDocumentTitle("Test Automation Report");
                sparkReporter.config().setReportName("Execution Results");
                sparkReporter.config().setTheme(Theme.DARK);

                // Initialize ExtentReports and attach the reporter
                extent = new ExtentReports();
                extent.attachReporter(sparkReporter);

                // Add system information
                extent.setSystemInfo("OS", System.getProperty("os.name"));
                extent.setSystemInfo("User", System.getProperty("user.name"));
                extent.setSystemInfo("Java Version", System.getProperty("java.version"));

                String os= testContext.getCurrentXmlTest().getParameter("os");
                extent.setSystemInfo("Operating system",os);

                String browser=testContext.getCurrentXmlTest().getParameter("browser");
                extent.setSystemInfo("Browser",browser);
            }



        /**
         * Get the ExtentTest object for the current thread.
         */
        public void onTestSuccess(ITestResult result)
        {

                test = extent.createTest(result.getTestClass().getName());
                test.assignCategory(result.getMethod().getMethodName());
                test.log(Status.PASS, result.getName() + " got successfully executed");



        }
        public void onTestFailure(ITestResult result)
        {
            test=extent.createTest(result.getTestClass().getName());
            test.assignCategory(result.getMethod().getMethodName());
            test.log(Status.FAIL,result.getName()+" got failed");
            test.log(Status.INFO,result.getThrowable().getMessage());

        }
        public void onTestSkipped(ITestResult result)
        {
            test=extent.createTest(result.getTestClass().getName());
            test.assignCategory(result.getMethod().getMethodName());
            test.log(Status.SKIP,result.getName()+" got skipped");
            test.log(Status.INFO,result.getThrowable().getMessage());

        }

/*
        *//**
         * Set the ExtentTest object for the current thread.
         *//*
        public void setTest(String testName, String description) {
            ExtentTest test = extent.createTest(testName, description);
            extentTest.set(test);*/


        /**
         * Close and flush the ExtentReports instance.
         */
        public void onFinish(ITestContext testContext)
        {
            extent.flush();
            //String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            /*String pathOfExtentReport=System.getProperty("src/test/Reports")+"\\reports\\"+ parsedDate + ".html";
            File extentReport=new File(pathOfExtentReport);
            try{
                Desktop.getDesktop().browse(extentReport.toURI());
            }
            catch (IOException e)

            {
                e.printStackTrace();
            }*/
        }
        }



