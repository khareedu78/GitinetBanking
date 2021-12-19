package inetBanking.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL =readconfig.getApplicationURL();
	public String username =readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		if(br.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		

	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
