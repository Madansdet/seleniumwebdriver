package homepage_test;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage_ImagesInArrivalsShouldNavigate_3 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("WebPage is Loading");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Shop']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
		WebElement sliderclick = driver.findElement(By.xpath("//div[@id='n2-ss-6-arrow-next']//img[@alt='Arrow']"));

		for (int i=0; i<=3; i++)
		{
			sliderclick.click();

		}

		List<WebElement> slides = driver.findElements(By.xpath("//img[contains(@class, 'n2-ss-slide-background-image')]"));
		int slidecount = slides.size();
		System.out.println("Count of Slides is " + slidecount);

		List<WebElement> Arrivals = driver.findElements(By.xpath("//img [contains(@class, 'attachment-shop_catalog size')]"));
		int ArrivalsCount = Arrivals.size();
		System.out.println("Count of Arrivals is " + ArrivalsCount);
		
		driver.findElement(By.xpath("//img[@title='Selenium Ruby']")).click();
		String Navigated = driver.getCurrentUrl();
		System.out.println("Current Navigated Page is " + Navigated);
		if (Navigated.equals("https://practice.automationtesting.in/product/selenium-ruby/"))
		{
			System.out.println("WebPage has Navigated to Next Page");
		}
		else
		{
			System.out.println("Page Not Navigated");	
		}
		driver.findElement(By.xpath("//img[@title='Selenium Ruby']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='pp_close']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		boolean AddToCart = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		Assert.assertTrue(AddToCart, "The button should be displayed.");
		System.out.println("Add to Cart button is there");
	}

}
