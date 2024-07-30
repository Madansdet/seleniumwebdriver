package homepage_test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_ArrivalsAddToBasketItemsCoupon_9 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("WebPage is Loading");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
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
		boolean AddToCart = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
		Assert.assertTrue(AddToCart, "The button should be displayed.");
		System.out.println("Add to Cart button is there");
		
		boolean description = driver.findElement(By.xpath("//div[@id='tab-description']//p[contains(text(),'The Selenium WebDriver Recipes book is a quick pro')]")).isDisplayed();
		Assert.assertTrue(description);
		System.out.println("Description is there");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript ("return window.pageYOffset;"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript ("return window.pageYOffset;"));
		
		driver.findElement(By.xpath("//a[normalize-space()='Reviews (0)']")).click();
		boolean Price = driver.findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']")).isDisplayed();
		Assert.assertTrue(Price);
		System.out.println("Price is Visible");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		/*WebElement addtocart = driver.findElement(By.xpath("//input[@title='Qty']"));
		Thread.sleep(3000);
		for(int i = 0; i<=5 ; i++)
		{
			addtocart.click();
		}*/
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("5");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[@class='cartcontents']")).click();
		String purchase = driver.getCurrentUrl();
		if (purchase.equals("https://practice.automationtesting.in/basket/"))
		{
			System.out.println("Navigated to checkoutpage");
		}
		driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("krishnasakinala");
		driver.findElement(By.xpath("//input[@name='apply_coupon']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'woocommerce-message')]")));
	    String couponApplied = driver.findElement(By.xpath("//tr[contains(@class,'cart-discount')]//span[contains(@class,'woocommerce-Price-amount')]")).getText();
	    Assert.isTrue(couponApplied.contains("50.00"), "Coupon is not applied");
	    driver.close();
		        
		
	}

}
