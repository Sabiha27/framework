package baseController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase {
	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentTest ParentTest;
	public static ExtentTest childTest;
	public static SoftAssert soft;

	@BeforeSuite
	public void getInstance() throws IOException {
		fis = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fis);
	    htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
	    htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Testing Extent Report");
		htmlReporter.config().setTheme(Theme.DARK);
		 
	    reports=new ExtentReports(); 
		reports.attachReporter(htmlReporter);
		//reports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		soft = new SoftAssert();

	}

	@BeforeMethod
	public void setUpEnv() throws Exception {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");

		String pageloadwait = properties.getProperty("pageloadwaittime");
		long pageload_wait = Long.parseLong(pageloadwait);

		String implicitWait = properties.getProperty("implicitWaitTime");
		long implicit_Wait = Long.parseLong(implicitWait);

		if ("Chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver78.exe");
			driver = new ChromeDriver();

		}
		if ("Firefox".equals(browser)) {
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageload_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicit_Wait, TimeUnit.SECONDS);
		driver.get(url);

	}

	@AfterSuite

	public void tearDownMethod() {
		reports.flush();

	}

	@AfterMethod

	public void tearDown(ITestResult result) {
		/*
		 * if (result.getStatus() == ITestResult.FAILURE) {
		 * test.log(LogStatus.FAIL, "TestCase is fail" + result.getName());
		 * test.log(LogStatus.FAIL, "TestCase is fail" + result.getThrowable());
		 * 
		 * } else if (result.getStatus() == ITestResult.SUCCESS) {
		 * test.log(LogStatus.PASS, "TestCase is pass" + result.getName()); }
		 * else { test.log(LogStatus.SKIP, "TestCase is skip" +
		 * result.getName()); }
		 */


		driver.close();
	}
}
