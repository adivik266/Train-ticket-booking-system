package test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class irctc {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aditya\\Downloads\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//Notifications allow
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		
		//IRCTC site
		driver.manage().window().maximize();
		driver.get("http://www.irctc.co.in");
		
		//Opening login page
		WebElement ok=driver.findElement(By.className("btn-primary"));
		ok.click();
		driver.findElement(By.linkText("LOGIN")).click();

		//LOGIN
		WebElement username=driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/app-login/p-dialog[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/div[1]/input"));
		username.sendKeys("adityavikram");
		WebElement password=driver.findElement(By.xpath("/html/body/app-root/app-home/div[3]/app-login/p-dialog[1]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/div[2]/input"));
		password.sendKeys("Aditya@266");
		WebElement clickable = driver.findElement(By.id("nlpAnswer"));
		clickable.click();
		Thread.sleep(5000);
		WebElement signin=driver.findElement(By.xpath("//button[text()='SIGN IN']"));
		signin.click();
		
		//Journey details
		Thread.sleep(1000);
		WebElement from=driver.findElement(By.cssSelector("#origin > span > input"));
		from.sendKeys("ndls");
		from.sendKeys(Keys.ENTER);
		WebElement to=driver.findElement(By.cssSelector("#destination > span > input"));
		to.sendKeys("gkp");
		to.sendKeys(Keys.ENTER);
		WebElement date=driver.findElement(By.cssSelector("#jDate > span > input"));
		date.sendKeys("_");
		date.clear();
		date.sendKeys("25/06/2022");
		driver.findElement(By.cssSelector("#journeyQuota > div")).click();
		driver.findElement(By.cssSelector("#journeyQuota > div > div.ng-trigger.ng-trigger-overlayAnimation.ng-tns-c66-12.ui-dropdown-panel.ui-widget.ui-widget-content.ui-corner-all.ui-shadow.ng-star-inserted > div > ul > p-dropdownitem:nth-child(5) > li")).click();
		WebElement search=driver.findElement(By.cssSelector(".search_btn.train_Search"));
		search.click();
	}

}
