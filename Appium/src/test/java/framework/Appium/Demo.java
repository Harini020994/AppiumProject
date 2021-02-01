package framework.Appium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Demo extends Capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException {
		//driver=capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		
	}

	@Test(enabled=false)
	public void testcase1() {
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Harini");
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		System.out.println(name);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String Expected="Harini";
		Assert.assertEquals(name,Expected);
	}
	@Test(enabled=false)
	public void testcase2() {
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		//driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Harini");
		//String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		//System.out.println(name);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String errmsg=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		String exp="Please enter your name";
		System.out.println(errmsg);
		Assert.assertEquals(exp,errmsg);
		
	}
	@Test(enabled=false)
	public void testcase3() {
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Harini");
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		System.out.println(name);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String Expected="Harini";
		Assert.assertEquals(name,Expected);
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
		//int l1=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		//System.out.println(l1);
		//driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
	
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\").instance(0)).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		int l1=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<l1;i++)
		{
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String cartProductName=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		String ProductName="Air Jordan 9 Retro";
		Assert.assertEquals(cartProductName,ProductName);			
		
		
	}
	@Test
	public void testcase4() throws InterruptedException, IOException {
		service=startServer();
		driver=capabilities(appPackage,appActivity,deviceName,platformName,chromeExecutable);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys("Harini");
		String name=driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).getAttribute("text");
		System.out.println(name);
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		amount1=amount1.substring(1);
		Double amount1value=Double.parseDouble(amount1);
		String amount2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		amount2=amount2.substring(1);
		Double amount2value=Double.parseDouble(amount2);
		Double Totalvalue=amount1value+amount2value;
		
		String FinalAmount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		FinalAmount=FinalAmount.substring(1);
		Double FinalAmountvalue=Double.parseDouble(FinalAmount);
		Assert.assertEquals(FinalAmountvalue,Totalvalue);
		
		WebElement tap=driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t=new TouchAction(driver);
		t.tap(tapOptions().withElement(element(tap))).perform();
		
		//long press on terms and conditions
		WebElement Lp=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(Lp)).withDuration(ofSeconds(3))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(10000);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("IBM");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		//Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		service.stop();
	
}
}