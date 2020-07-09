package pages;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="b_tt_holder_1")
	public	WebElement LanguageSelector;

	@FindBy(xpath = "//span[@lang=\"en-us\"][1]")
	public WebElement EnglishLanguage;

	@FindBy(id="ss")
	public WebElement DestinationTxtBox;

	@FindBy(css = ".xp__dates__checkin .sb-date__field-svg_icon > [aria-hidden='true']:nth-child(1)")
	public WebElement CalenderDialogue;

	@FindBy(xpath = "//div[@class='xp__dates xp__group']//div[@class='xp__dates-inner xp__dates__checkin']")
	public WebElement CheckinDateInputBox;

	@FindBy(xpath = "//div[@class='xp__dates xp__group']//div[@class='xp__dates-inner xp__dates__checkout']")
	public WebElement CheckoutDateInputBox;

	@FindBy(css = "[data-bui-ref] [data-bui-ref='calendar-month']:nth-of-type(1) [aria-live]")
	public WebElement currentMonth;

	@FindBy(css = "[aria-label='16 July 2020'] [aria-hidden]")
	public WebElement Randomdate1;


	@FindBy(css = "[aria-label='24 July 2020'] [aria-hidden]")
	public WebElement Randomdate2;

	@FindBy(css = "[data-bui-ref='calendar-next'] svg")
	public WebElement NextArrow;

	@FindBy(className = "sb-searchbox__button ")
	public WebElement searchBtn;


	// to make sure that the language selected is English
	public void selectEnglishLanguage()

	{
		clickElement(LanguageSelector);
		clickElement(EnglishLanguage);
	}


	public void setDestination(String destination) throws Exception
	{
		DestinationTxtBox.clear();
		Thread.sleep(1000);
		setTextElementText(DestinationTxtBox, destination);
	}

	public void setDates(String Month,String arrivalDay, String departureDay) throws Exception

	{
		clickElement(CalenderDialogue);
		
		Thread.sleep(3000);
        float FloatFormatedarrivalDay = Float.valueOf(arrivalDay);
        int FormatedarrivalDay = (int) FloatFormatedarrivalDay;
        float FloatFormateddepartureDay = Float.valueOf(departureDay);
        int FormateddepartureDay = (int) FloatFormateddepartureDay;
		
		while(true) {

			String currentMonth = driver.findElement(By.xpath("(//div[@class='bui-calendar__month'])[1]")).getText();
			//String currentMonth = driver.findElement(By.id("bui-calendar-1594177558128ckobpn")).getText();

			if(currentMonth.equals(Month)) {
				
				break;
			}
			else {
				clickElement(NextArrow);
			}
			CheckinDateInputBox.clear();
			CheckoutDateInputBox.clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@aria-label='" + FormatedarrivalDay + " "+ Month + "']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@aria-label='" + FormateddepartureDay + " "+ Month + "']")).click();
		}


		//sol1
		/*clickElement(CheckinDateInputBox);
		Thread.sleep(1000);
		clickElement(Randomdate1);
		clickElement(Randomdate2);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('[data-placeholder='Check-in']').setAttribute('aria-hidden', 'false')");
		js.executeScript("document.querySelector('[data-placeholder='Check-in']').value='" +CheckinDate+"'");
		js.executeScript("document.querySelector('[data-placeholder='Check-out']').setAttribute('aria-hidden', 'false')");
		js.executeScript("document.querySelector('[data-placeholder='Check-out']').value='" +CheckoutDate+"'");*/

		//sol2
		/*DateTimeFormatter dateformtter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	    String dateformat1 = CheckinDate;
	    String dateformat2 = CheckoutDate;
	    OffsetDateTime dateTime1 = OffsetDateTime.parse(dateformat1);
	    OffsetDateTime dateTime2 = OffsetDateTime.parse(dateformat2);
	    String stringDateCheckinDate = dateTime1.format(dateformtter);
	    String stringDateCheckoutDate = dateTime2.format(dateformtter);*/

		//sol3
		/*SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-mm-dd");
		String stringDateCheckinDate = DateFor.format(CheckinDate);
		String stringDateCheckoutDate = DateFor.format(CheckoutDate);

		clickElement(CalenderDialogue);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if(driver.findElement(By.xpath("//td [@class='bui-calendar__date'][data-date=stringDateCheckinDate]")).isDisplayed()){

			driver.findElement(By.xpath("//td [@class='bui-calendar__date'][data-date=stringDateCheckinDate]")).click();
			driver.findElement(By.xpath("//td [@class='bui-calendar__date'][data-date=stringDateCheckoutDate]")).click();
		}
			else{
				clickElement(NextArrow);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}*/
	}



	public void submitSearchdata()

	{
		submition(searchBtn);
	}
}
