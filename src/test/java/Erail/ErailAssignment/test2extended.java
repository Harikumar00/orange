package Erail.ErailAssignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test2extended {
	
	
		WebDriver driver;
		@Test(dataProvider="testdata")
		public void Erail() throws Exception{
			WebDriver driver = new ChromeDriver();

	        // Maximize the browser window
	        driver.manage().window().maximize();
	        Thread.sleep(1000);
	 
	        // Navigate to the specified URL
	        driver.get("https://erail.in/");
	        Thread.sleep(1000);
	       

	        driver.findElement(By.id("txtStationFrom"));
	        inputElement.clear();
	        inputElement.sendKeys("DEL");
	        
	        try {
	            // Open the target webpage
	            driver.get("URL_OF_YOUR_WEBPAGE");

	            // Calculate the date that is 30 days before today
	            LocalDate currentDate = LocalDate.now();
	            LocalDate dateBefore30Days = currentDate.minusDays(30);

	            // Format the date as needed (assuming format "MM/dd/yyyy")
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	            String formattedDate = dateBefore30Days.format(formatter);

	            // Locate the date picker element (replace with your specific locator strategy)
	            WebElement datePicker = driver.findElement(By.xpath("//*[@id=\"tdDateFromTo\"]/input"));

	            // Input the formatted date into the date picker field
	            datePicker.sendKeys(formattedDate);

	        } finally {
	        
	        
           // driver.findElement(By.xpath("//*[@id=\"tdDateFromTo\"]/input"));

            // Initialize the Select class with the dropdown WebElement
            Select dropdown = new Select(dropdownElement);

            // Select the 4th option in the dropdown (index starts from 0, so 3 is the 4th option)
            dropdown.selectByIndex(3);

            // Get the selected option and print its text
            WebElement selectedOption = dropdown.getFirstSelectedOption();
            System.out.println("Selected option: " + selectedOption.getText());
            
            
            
            
	         driver.findElement(By.name("password")).sendKeys("admin123");

	         Thread.sleep(100);
	//  driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
	       
	      driver.findElement(By.xpath("//button[@type='submit']")).click();
	       Thread.sleep(1000);
	driver.quit();
		} 
//		
//		@DataProvider(name="testdata")
//		public Object[][] tData()
//		{
//			return new Object[][] 
//					{
				{"Admin","admin123"},
				{"InvalidUser","invalid123"},
				{"AnotherInvalid","another123"}
	            };
	            
		}
	}





	
}