package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.StartUp;



public class LoginPage extends StartUp {
	
	public LoginPage(RemoteWebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="username")
	private WebElement user;
	public LoginPage userName(String usrName) {
		
		textBoxField(user, usrName);
		return this;
		
		
		
	}
	
	@FindBy(id="password")
	private WebElement pass;
	
	public LoginPage password(String pwd) {
		
		textBoxField(pass, pwd);
		return this;
		
	}
	
	@FindBy (id="login")
	private WebElement loginButton;
	public SearchHotel loginButton() {
		clickActions(loginButton);
		return new SearchHotel(driver);
	}
	
	
	

}
