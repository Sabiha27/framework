package CommonFile;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseController.TestBase;

public class CommonMethods extends TestBase{
	static String com  = properties.getProperty("commonmethods");
	public static void info(ExtentTest childTest, String message) {
		if("yes".equals(com)){
		childTest.log(Status.INFO, message);
		}
	}

	public static void pass(ExtentTest childTest, String message) {
		if("yes".equals(com)){
		childTest.log(Status.PASS, message);
		}
	}

	public static void fail(ExtentTest childTest, String message) {
		if("yes".equals(com)){
		childTest.log(Status.FAIL, message);
		//return test;
		}

	}
}
