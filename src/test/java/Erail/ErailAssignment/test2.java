package Erail.ErailAssignment;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class test2 {
	WebDriver driver;
	@Test(dataProvider="testdata")
	public void logintest(String username, String password) throws Exception{
		WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
        Thread.sleep(1000);
 
        // Navigate to the specified URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
       

        driver.findElement(By.name("username")).sendKeys("Admin");
         driver.findElement(By.name("password")).sendKeys("admin123");

         Thread.sleep(100);
//  driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
       
      driver.findElement(By.xpath("//button[@type='submit']")).click();
       Thread.sleep(1000);
driver.quit();
	} 
	
	@DataProvider(name="testdata")
	public Object[][] tData()
	{
		return new Object[][] 
				{
			{"Admin","admin123"},
			{"InvalidUser","invalid123"},
			{"AnotherInvalid","another123"}
            };
            
	}
}




