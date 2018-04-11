package configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.MethodDeclaration;

public class configuration implements MethodDeclaration {

	public static RemoteWebDriver driver;
	static int i=1;
	
	
	public void openBrowser(String browser, String url) {
	
		switch(browser) {
		
		case "chrome": System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
						driver = new ChromeDriver();
						break;
		case "ie"	  : System.setProperty("webdriver.ie.driver", "/drivers/chromedriver.exe");
						driver = new InternetExplorerDriver();
						break;
						
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		
	}

	public void verifyTitle(String data) {

		String title = driver.getTitle();
		
		if (title.equalsIgnoreCase(data)) {
			Assert.assertEquals(data, title);
		}
		
	}

	public WebElement findLocators(String locator, String locatorValue) {

		WebElement element = null;
		switch(locator) {
		
		case "id": element = driver.findElement(By.id(locatorValue));
		break;
		case "name": element = driver.findElement(By.name(locatorValue));
		break;
		case "class": element = driver.findElement(By.className(locatorValue));
		break;
		case "linkText": element = driver.findElement(By.linkText(locatorValue));
		break;
		case "xpath": element = driver.findElement(By.xpath(locatorValue));
		break;
		case "tag": element = driver.findElement(By.tagName(locatorValue));
		break;
		}
		
		return element;
	}

	public void textBoxField(WebElement element, String data) {
		
		element.clear();
		element.sendKeys(data);
		
		
	}

	public void clickActions(WebElement element) {

		element.click();
		
	}

	public void dropdownSelection(WebElement element, String data) {
		
		Select option = new Select(element);
		//option.selectByVisibleText(data);
		List<WebElement> value = option.getOptions();
		
		for (WebElement allOptions : value) {
			
			if (allOptions.equals(data)) {
			allOptions.click();
			}
		}
		
	}

	public void getText(WebElement element) {
		String text = element.getText();
		
	}

	public void getAttribute(WebElement element, String data) {
		String attribute = element.getAttribute(data);
		
	}

	public void alertAccept() {
		driver.switchTo().alert().accept();
		
	}

	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
		
	}

	public void takeScreenshot() throws IOException {
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,  new File(".driver/image"+i+".png"));
		i++;
	}

	public void swithcToWindow(String data) {
		
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		
		for (String allWindow : childWindow) {
			
			if (allWindow!=parentWindow) {
				driver.switchTo().window(allWindow);
			}
			
		}
		
		
		
		
	}

	public void swithcToFrame(String data) {
		driver.switchTo().frame(data);
		
	}

	public void tableSelection(WebElement element, String data) {
	
		
		List<WebElement> tr = element.findElements(By.tagName("tr"));
		
		for (int i=0;i<=tr.size();i++) {
			List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
			for (int j=0;j<td.size();j++) {
				
				String value = td.get(0).getText();
				
				if (value.equalsIgnoreCase(data)) {
					td.get(0).click();
				}
			}
		}
		
		
		
	}

	public void closeBrowser() {
		driver.quit();
		
	}

	
	public void defaultWindow() {

driver.switchTo().defaultContent();
		
	}

}
