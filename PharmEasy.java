package exam;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 Automate below Scenerio
1. Launch https://pharmeasy.in/
2. Search PCM
3. Click on 3rd option
4. From the list of search result click on 3rd product
5. Select the quantity as 2
6. Click on View cart
After automating push your file to your github repo
*
 */

public class PharmEasy {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://pharmeasy.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		WebElement searchbutton = driver.findElement(By.xpath("//button[@aria-label='Search']"));
		searchbutton.click();
		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath("//input"));
		search.sendKeys("PCM");

		Thread.sleep(5000);
		
		//auto suggestion choose 3rd option
		List<WebElement> auto = driver
				.findElements(By.xpath("//div[@class='typeahead-lib-Typeahead-module_result__tF-Yj']"));

		auto.get(2).click();

		Thread.sleep(4000);
//click on 3rd product
		List<WebElement> option = driver.findElements(
				By.xpath("//div[@class='LHS_container__sXYjF Search_fullWidthLHS__LIkF0']/descendant::h1"));

		option.get(2).click();
		Thread.sleep(3000);

		WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
		addtocart.click();
		Thread.sleep(2000);

		WebElement qty = driver.findElement(By.xpath("//span[text()='2']"));

		Actions a1 = new Actions(driver);
		a1.moveToElement(qty).perform();

		qty.click();
		Thread.sleep(2000);

		WebElement viewcart = driver.findElement(By.xpath("//a[text()='View Cart']"));
		viewcart.click();
		Thread.sleep(2000);

	}
}
