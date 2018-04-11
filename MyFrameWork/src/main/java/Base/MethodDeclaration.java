package Base;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public interface MethodDeclaration {
	
	public void openBrowser(String browser, String url);
	public void verifyTitle(String data);
	public WebElement findLocators(String locator, String locatorValue);
	public void textBoxField(WebElement element, String data);
	public void clickActions(WebElement element);
	public void dropdownSelection(WebElement element, String data);
	public void getText(WebElement element);
	public void getAttribute(WebElement element, String data);
	public void alertAccept();
	public void alertDismiss();
	public void takeScreenshot() throws IOException;
	public void swithcToWindow(String data);
	public void swithcToFrame(String data);
	public void tableSelection(WebElement element, String data);
	public void defaultWindow();
	public void closeBrowser();
	
	
	
	

}
