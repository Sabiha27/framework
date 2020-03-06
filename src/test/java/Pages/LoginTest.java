package Pages;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import CommonFile.CommonMethods;
import baseController.TestBase;

public class LoginTest extends TestBase {

	@Test(priority = 1)
	public void verifyLoginPage() throws IOException {
		// test = reports.startTest("verify loginTitle page");
		ParentTest = reports.createTest("LoginTest");
		childTest = ParentTest.createNode("verifyLoginPage");
		String actTitle1 = driver.getTitle();
		System.out.println("actTitle>>>>" + actTitle1);
		CommonMethods.info(childTest, "Actual Title" + actTitle1);
		String expTitle1 = "JavaByKiran | Log in";
		CommonMethods.info(childTest, "expected error message");
		if (actTitle1.equals(expTitle1)) {
			CommonMethods.pass(childTest, "Actual error & Expected error are equals");
			soft.assertEquals(actTitle1, expTitle1);
		} else {
			CommonMethods.fail(childTest, "Actual error & Expected error are not equals");
			soft.assertEquals(actTitle1, expTitle1);

		}

		soft.assertAll();

	}

	@Test(priority = 2)
	public void checkErrorMessage1() throws IOException {
		// test = reports.startTest("checkErrorMessage1");
		ParentTest = reports.createTest("LoginTest");
		childTest = ParentTest.createNode("checkErrorMessage1");
		driver.findElement(By.id("email")).sendKeys("kiran111@gmail.com");
		CommonMethods.info(childTest, "sending email");
		driver.findElement(By.id("password")).sendKeys("123456");
		CommonMethods.info(childTest, "sending password");
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		CommonMethods.info(childTest, "clicking on sign In button");
		String actErrorMessage1 = driver.findElement(By.xpath("//*[@id='email_error']")).getText();
		System.out.println("actErrorMessage1" + actErrorMessage1);
		CommonMethods.info(childTest, "actual error message");
		String expMessage1 = "Please enter email as kiran123@gmail.com";
		CommonMethods.info(childTest, "expected error message");
		if (actErrorMessage1.equals(expMessage1)) {
			CommonMethods.pass(childTest, "Actual error & Expected error are equals");
			soft.assertEquals(actErrorMessage1, expMessage1);
		} else {
			CommonMethods.fail(childTest, "Actual error & Expected error are not equals");
			soft.assertEquals(actErrorMessage1, expMessage1);

		}

		soft.assertAll();
	}

}
