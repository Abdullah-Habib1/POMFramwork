package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class Helper {

	//Method to capture screen shot on failures
	public static void captureScreenShot(WebDriver driver, String screenShotName) throws IOException {

		Path destination = Paths.get("./ScreenShots",screenShotName+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream outResult = new FileOutputStream(destination.toString());
			outResult.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			outResult.close();
		} catch (Exception e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
	}
	}