package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.StartUp;

public class SearchHotel extends StartUp {

	
	public SearchHotel(RemoteWebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
}
