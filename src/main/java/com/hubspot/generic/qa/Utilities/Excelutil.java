package com.hubspot.generic.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hubspot.generic.qa.BasePage.BasePage;

public class Excelutil extends BasePage {

	

	private static Workbook book;
	private static Sheet sheet;
	private static String TEST_DATA_SHEET_PATH = "C:\\Users\\Bhisma\\eclipse-workspace\\hubspot_generic\\src\\main\\java"
			+ "\\com\\hubspot\\generic\\qa\\testdata\\HubspotTestdata.xlsx";

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {

		Object data[][] = null;

		try {
			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {

				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}


	public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");		
	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	
}

}





