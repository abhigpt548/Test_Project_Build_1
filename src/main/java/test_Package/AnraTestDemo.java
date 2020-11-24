package test_Package;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.lf5.viewer.categoryexplorer.TreeModelAdapter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.Test_Base;

public class AnraTestDemo extends Test_Base {
	
	public void testBegin() throws InterruptedException {
		
		WebElement searchTextBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		searchTextBox.sendKeys("Selenium Books");
		
		Thread.sleep(2000);
		WebElement submitSearchBtn = driver.findElement(By.cssSelector("input[type=submit]"));
		submitSearchBtn.click();
		
		Thread.sleep(2000);
		
		WebElement nextPaginationBtn = driver.findElement(By.xpath("//a[contains(text(),'Next')]"));
		wait.until(ExpectedConditions.visibilityOf(nextPaginationBtn));
		Point p = nextPaginationBtn.getLocation();
		int y = p.getY();
		String command = "window.scrollTo(0,"+y+")";
		r.executeScript(command);
		nextPaginationBtn.click();
		
		//a[@class='a-size-base a-link-normal a-text-bold'][contains(text(),'Paperback')]//parent::div//following::div/div/div/a/span/span
		
		WebElement sortByFilter = driver.findElement(By.xpath("//span[@id='a-autoid-1-announce']"));
		wait.until(ExpectedConditions.visibilityOf(sortByFilter));
		sortByFilter.click();
	
		Thread.sleep(2000);
	
		WebElement lowToHigh = driver.findElement(By.xpath("//a[contains(text(),'Price: Low to High')]"));
		wait.until(ExpectedConditions.visibilityOf(lowToHigh));
		lowToHigh.click();
		
		WebElement lowestPriceBook = driver.findElement(By.xpath("(//span//parent::a//parent::h2//parent::div)[1]"));
		ac = new Actions(driver);
		ac.moveToElement(lowestPriceBook).perform();
		lowestPriceBook.click();
		
		WebElement buyNowBtn = driver.findElement(By.cssSelector("input#checkout-button"));
		wait.until(ExpectedConditions.visibilityOf(buyNowBtn));
		buyNowBtn.click();
		
		
		
		//WebElement nationalId = driver.findElement(By.xpath("//input[@id='txtNationalID']//following::span/span[contains(text(),'National Identity is ')]"));
		//Assert.assertEquals(nationalId.getText(), "National Identity is Required.....", "The National Id not Filled");
		
	}

}
