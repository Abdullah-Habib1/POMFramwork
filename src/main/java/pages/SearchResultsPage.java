package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends PageBase{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="sortbar_dropdown_button")
	public	WebElement SortBarMenu;

	@FindBy(linkText ="Top Reviewed")
	public	WebElement TopReviewedHotels;


	public void printTopFiveHotels() throws InterruptedException

	{
		clickElement(SortBarMenu);
		Thread.sleep(2000);

		clickElement(TopReviewedHotels);

		List<WebElement> HotelNames = driver.findElements(By.className("sr-hotel__name"));

		List<WebElement> HotelRating = driver.findElements(By.className("bui-review-score__title"));

		for(int i=0;i<5;i++)
		{
			System.out.printf("%s\t%s\n", HotelNames.get(i).getText(),HotelRating.get(i).getText());
		}

	}
}
