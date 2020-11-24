package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Actions ac;
	public static WebDriverWait wait;
	public static RemoteWebDriver r;
	
	public Test_Base(){
	
		try{
			
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\abhig\\Abhinav Workspace\\New_Maven_Test_Project\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromDriverPAth"));
			driver = new ChromeDriver();
			
		}
		else if(browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "ChromDriverPAth");
					driver = new FirefoxDriver();
		}
		ac = new Actions(driver);
		wait = new WebDriverWait(driver, 4);
		r= (RemoteWebDriver)driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("Url"));
	}
	
	
	

}
