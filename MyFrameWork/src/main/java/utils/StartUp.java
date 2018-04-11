package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import configuration.configuration;

public class StartUp extends configuration {
	
	
	public String xlFile;
	public  Properties prop;
	public String file = "F:\\Pradeep_Selenium\\Workspace\\MyFrameWork\\src\\main\\java\\properties\\Variables.properties";
	
	
	@BeforeMethod
	public void openWebBrowser() throws IOException {
		prop = new Properties();
		FileInputStream loct = new FileInputStream(file);
		prop.load(loct);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		openBrowser(browser, url);
		
	}
	
	
	@DataProvider (name = "getData")
	public Object [][] readExcel() throws IOException {
		ReadXL obj = new ReadXL();
		return obj.readExcel(xlFile);
		
	}
	
	
	public void closeAllBrowser() {
		closeBrowser();
	}
	

}
