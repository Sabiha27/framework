package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import CommonFile.CommonMethods;
import baseController.TestBase;

public class SignUp extends TestBase {
	
	@Test(priority = 3)
	public void SigUpTest() throws IOException {
		ParentTest=reports.createTest("SignUp");
		childTest=ParentTest.createNode("SigUpTest");
		driver.findElement(By.id("email")).sendKeys("");
		CommonMethods.info(childTest, "sending blank email");
		driver.findElement(By.id("password")).sendKeys("");
		CommonMethods.info(childTest, "sending blank password");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		CommonMethods.info(childTest, "clicking on sign In button");
		String actErrorMessage2 = driver.findElement(By.xpath("//*[@id=\"password_error\"]")).getText();
		CommonMethods.info(childTest, "actual error message");
		String expMessage2 = "Please enter password.";
		CommonMethods.info(childTest, "expected error message");
		if (actErrorMessage2.equals(expMessage2)) {
			CommonMethods.pass(childTest, "Actual error & Expected error are equals");
			soft.assertEquals(actErrorMessage2, expMessage2);
		} else {
			CommonMethods.fail(childTest, "Actual error & Expected error are not equals");
			soft.assertEquals(actErrorMessage2, expMessage2);

		soft.assertAll();

	}
	}

}