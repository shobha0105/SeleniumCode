package generic;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumBase extends Base {
	static WebDriver driver; // interface webdriver cant be instantiated
	Logger log;
	public SeleniumBase(){
		log = LogManager.getLogger(SeleniumBase.class);
	}
	
	public enum locators {
		id, name, className, tagName, linkText, partialLinkText, cssSelector, xpath
	};

	
	
	public void launchApplication(String browsername, String url) {
		System.out.println(SeleniumBase.class);
		
		log.debug("Launching "+ browsername + "browser");
		String path = null;
		if (browsername.equalsIgnoreCase("chrome")) {
			path = this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver(); // instantiating will launch browser
		} else if (browsername.equalsIgnoreCase("firefox")) {
			path = this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", path);
						
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("ie")) {
			path = this.getCurrentDirectorypathandConcat("\\src\\test\\java\\Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", path);
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("browser name is incorrect");
		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url); // hit the url
		log.trace("Launching "+ url + browsername + "browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void explicitWait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ExpectedConditions ec = null; // object cant be created because constructor is private // ExpectedConditions
										// is a class and ExpectedCondition is an interface
		
		//ExpectedCondition<WebElement> sss = ExpectedConditions.visibilityOfElementLocated(by); // object of ExpectedCondition
															// is returned (not
																			// ExpectedConditions)
		// function is parent of ExpecetdFunction so pass arg of until -> function/means
		// child :expected function
		ExpectedCondition<WebElement> sss = ExpectedConditions.visibilityOfElementLocated(by);
		wait.until(sss);
	}

	public WebElement IdentifyElement(locators type, String value) { // this method skips write
		By by = null;
		switch (type) {
		case id:
			by = By.id(value);
			break;
		case name:
			by = By.name(value);
			break;
		case className:
			by = By.className(value);
			break;
		case tagName:
			by = By.tagName(value);
			break;
		case linkText:
			by = By.linkText(value);
			break;
		case partialLinkText:
			by = By.partialLinkText(value);
			break;
		case cssSelector:
			by = By.cssSelector(value);
			break;
		case xpath:
			by = By.xpath(value);
			break;
		}
		return driver.findElement(by);

	}

	public List<WebElement> IdentifyElements(locators type, String value) { // this method skips write
		By by = null;
		switch (type) {
		case id:
			by = By.id(value);
			break;
		case name:
			by = By.name(value);
			break;
		case className:
			by = By.className(value);
			break;
		case tagName:
			by = By.tagName(value);
			break;
		case linkText:
			by = By.linkText(value);
			break;
		case partialLinkText:
			by = By.partialLinkText(value);
			break;
		case cssSelector:
			by = By.cssSelector(value);
			break;
		case xpath:
			by = By.xpath(value);
			break;
		}
		return driver.findElements(by);

	}

	public void closeApplication(boolean flag) {
		if (flag) {
			driver.quit(); // closes all open instances of browser
		} else
			driver.close(); // closes focused instance of browser only
	}

	public String getpageDetails(String type) {
		String return_value = null;
		if (type.equalsIgnoreCase("url")) {
			return_value = driver.getCurrentUrl();

		}

		return return_value;
	}

	public void selectFromDropdown(WebElement element, String value, String type) {
		

	}

	public String performAction(WebElement element, String type, String value, String... extra_parameters) {
		String returnValue = null;
		if (type.equalsIgnoreCase("click")) {
			element.click();
		} 
		else if (type.equalsIgnoreCase("settext")) {
			element.sendKeys(value);
		}
		else if (type.equalsIgnoreCase("gettext")) {
			returnValue = element.getText();
		}		
		else if(type.equalsIgnoreCase("dropdown")) {
			Select sel = new Select(element); // selecting value from dropdown //select by index, by attribute value, or
			// visible text option 1 or option 2}
			if (extra_parameters[0].equals("index")) {
				sel.selectByIndex(Integer.parseInt(value));
			} else if (extra_parameters[0].equalsIgnoreCase("value")) {
				sel.selectByValue(value);
			} else if (extra_parameters[0].equalsIgnoreCase("visibletext")) {
				sel.selectByVisibleText(value);
			}	
		}
		else if(type.equalsIgnoreCase("alert")) {
			Alert alert = driver.switchTo().alert();
			if (extra_parameters[0].equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (extra_parameters[0].equalsIgnoreCase("cancel")) {
				alert.dismiss();
			}
			else if (extra_parameters[0].equalsIgnoreCase("gettext")) {
				alert.getText();
			} 
			else if (extra_parameters[0].equalsIgnoreCase("settext")) {
				alert.sendKeys(value);
			}
		}
		
		else if (type.equalsIgnoreCase("windows")) {
			String parent_handle=driver.getWindowHandle();// IMP: wherever  is the selenium focus - is the parent_handle
			Set<String> handle = driver.getWindowHandles();// retruns all handles including parent handle
			for(String hand:handle) {
				if(hand.equals(parent_handle)) {
					continue; //moves to next iteration
				}
				else {
					driver.switchTo().window(hand);
					String actual_url=this.getpageDetails(extra_parameters[0]);
					if(actual_url.equals(value)) {
						break;
					}
					else {
						//performAction(null, "windows", null, extra_parameters[0] ); // recursion but it breaks when actual url matches expected url
					
					//alternative toabove statement
						continue; 
						}
				}
				
			}
		}
		return returnValue;
	}

	/*public void multiplewindows() {
		String mainWindow = driver.getWindowHandle();
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		
		// Using Iterator to iterate with in windows
		java.util.Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				// driver.close();
			}
		}

	}*/
}
