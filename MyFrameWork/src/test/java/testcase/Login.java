package testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.StartUp;

public class Login extends StartUp {
	
	
	public Properties prop;
	@BeforeTest
	public void testData() {
		
		xlFile = "F:\\Pradeep_Selenium\\framework.xlsx" ;
		
	}
	
	@Test (dataProvider = "getData")
	public void loginScreen(String SNo, String User) throws IOException {
		
		prop  = new Properties();
		FileInputStream filePath = new FileInputStream(file);
		prop.load(filePath);
		String usr = prop.getProperty("user");
		String pwd = prop.getProperty("password");
		
		
		new LoginPage(driver)
		.userName(usr)
		.password(pwd)
		.loginButton();
		
		
		
		
	}
	

}
