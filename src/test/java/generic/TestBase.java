package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import java.util.List;

import java.util.function.Function;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic.SeleniumBase.locators;


public class TestBase  extends Base{

	WebDriver driver; 
	enum locator{id, name, className, tagName, linkText, partialLinkText, xpath, cssSelector};
	
	public void launchapp(String browser,String url ) {
		String path=null;
		if(browser.equalsIgnoreCase("chrome")) {
			path=this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\chromedriver.exe");
			System.getProperty("webdriver.chrome.driver", path);
		}
		else if(browser.equalsIgnoreCase("ie")) {
			path=this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\IEDriverServer.exe");
			System.getProperty("webdriver.ie.driver", path);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			path=this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\geckodriver.exe");
			System.getProperty("webdriver.firefox.driver", path);
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
		
		public void closeApplication(boolean flag){
			if(flag) {
				driver.quit();}
			else 
				{driver.close();}
			
	}
		
		public WebElement IdentifyElementby(locator type,String value) {
			By by=null;
			switch(type) {
			case id: by=By.id(value);break;
			case name: by=By.name(value);break;
			case className: by=By.className(value);break;
			case linkText: by=By.linkText(value);break;
			case partialLinkText: by=By.partialLinkText(value);break;
			case tagName: by=By.tagName(value);break;
			case xpath: by=By.xpath(value);break;
			case cssSelector: by=By.cssSelector(value);break;
			}
			return driver.findElement(by);	
		}
	
		public List<WebElement> IdentifyElementsby(locator type,String value) {
			By by=null;
			switch(type) {
			case id: by=By.id(value);break;
			case name: by=By.name(value);break;
			case className: by=By.className(value);break;
			case linkText: by=By.linkText(value);break;
			case partialLinkText: by=By.partialLinkText(value);break;
			case tagName: by=By.tagName(value);break;
			case xpath: by=By.xpath(value);break;
			case cssSelector: by=By.cssSelector(value);break;
			}
			return (List<WebElement>) driver.findElements(by);	
			
		}
	
		public void explicitWait(By by) {
			WebDriverWait wait=new WebDriverWait(driver,20);
			ExpectedConditions ecs;
			ExpectedCondition<List<WebElement>>  ec=ExpectedConditions.presenceOfAllElementsLocatedBy(by);
			wait.until(ec);
			
			
		}
	

}
