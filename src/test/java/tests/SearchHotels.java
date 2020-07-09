package tests;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.SearchResultsPage;



public class SearchHotels extends TestBase {

	HomePage homeObject;
	SearchResultsPage SearchResultsObject;
	ExcelReader ExcelReaderObject;
	SearchHotels SearchObject;

	//String MonthTxtFound = homeObject.currentMonth.getText();



	@DataProvider(name="ExcelData")
	public Object[][] searchData() throws IOException
	{
		// get data from Excel Reader class 
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();

	}


	@Test(priority = 1,alwaysRun=true,dataProvider="ExcelData")
	public void searchAndPrintTopFiveHotels(String destination, String Month,String arrivalDay,String departureDay) throws Exception {

		homeObject = new HomePage(driver);
		//homeObject.selectEnglishLanguage();
		homeObject.setDestination(destination);
		homeObject.setDates(Month, arrivalDay, departureDay);
		homeObject.submitSearchdata();
		Thread.sleep(2000);
		SearchResultsObject = new SearchResultsPage(driver);
		SearchResultsObject.printTopFiveHotels();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.booking.com/");

	}
}
