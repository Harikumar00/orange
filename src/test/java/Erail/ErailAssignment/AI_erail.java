package Erail.ErailAssignment;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class AI_erail {
	    public static void main(String[] args) throws Exception {
	        // Step 1: Open URL with web driver
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://erail.in/");

	        // Step 2: Click on from field
	        WebElement fromField = new WebDriverWait(driver, 10).until(
	                ExpectedConditions.elementToBeClickable(By.id("from"))
	        );
	        fromField.click();

	        // Step 3: Clear the data from “From” field
	        fromField.clear();

	        // Step 4: Insert data “DEL” in the field to open the drop down
	        fromField.sendKeys("DEL");

	        // Step 5: Select the station at 4th position in the dropdown & print it
	        List<WebElement> dropdownOptions = new WebDriverWait(driver, 10).until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#from option"))
	        );
	        WebElement fourthOption = dropdownOptions.get(3);
	        System.out.println(fourthOption.getText());
	        fourthOption.click();

	        // Step 6: Create an excel file with expected station names
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Expected Stations");
	        Row row = sheet.createRow(0);
	        Cell cell = row.createCell(0);
	        cell.setCellValue("Expected Station Names");
	        row = sheet.createRow(1);
	        cell = row.createCell(0);
	        cell.setCellValue("New Delhi");
	        row = sheet.createRow(2);
	        cell = row.createCell(0);
	        cell.setCellValue("Old Delhi");
	        row = sheet.createRow(3);
	        cell = row.createCell(0);
	        cell.setCellValue("Hazrat Nizamuddin");
	        row = sheet.createRow(4);
	        cell = row.createCell(0);
	        cell.setCellValue("Anand Vihar");

	        // Step 7: Get the list of data from the drop-down list & write it into an excel file & compare it with the existing expected station name
	        dropdownOptions = new WebDriverWait(driver, 10).until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#from option"))
	        );
	        List<String> actualStations = dropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
	        row = sheet.createRow(5);
	        cell = row.createCell(0);
	        cell.setCellValue("Actual Station Names");
	        for (int i = 0; i < actualStations.size(); i++) {
	            row = sheet.createRow(6 + i);
	            cell = row.createCell(0);
	            cell.setCellValue(actualStations.get(i));
	        }

	        // Compare actual stations with expected stations
	        for (int i = 1; i <= 4; i++) {
	            row = sheet.getRow(i);
	            cell = row.getCell(0);
	            String expectedStation = cell.getStringCellValue();
	            if (actualStations.contains(expectedStation)) {
	                System.out.println("Expected station " + expectedStation + " found in actual stations");
	            } else {
	                System.out.println("Expected station " + expectedStation + " not found in actual stations");
	            }
	        }

	        // Step 8: Select 30 days from the current date in “Sort on Date”
	        LocalDate currentDate = LocalDate.now();
	        LocalDate futureDate = currentDate.plusDays(30);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String futureDateStr = futureDate.format(formatter);
	        WebElement sortOnDateField = new WebDriverWait(driver, 10).until(
	                ExpectedConditions.elementToBeClickable(By.id("sortOnDate"))
	        );
	        sortOnDateField.click();
	        WebElement calendarTable = new WebDriverWait(driver, 10).until(
	                ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div"))
	        );
	        List<WebElement> calendarRows = calendarTable.findElements(By.tagName("tr"));
	        for (WebElement rowElement : calendarRows) {
	            List<WebElement> cells = rowElement.findElements(By.tagName("td"));
	            for (WebElement cellElement : cells) {
	                if (cellElement.getText().equals(futureDateStr)) {
	                    cellElement.click();
	                    break;
	                }
	            }
	        }

	        // Save the excel file
	        workbook.write(new FileOutputStream("station_names.xlsx"));
	    }
	}
}
