package cm.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;
import com.google.common.io.Files;

public class TestUtil extends TestBase{
public static long PAGE_LOAD_TIMEOUT=20;
public static long IMPLICIT_WAIT=20;
public static String TESTDATA_SHEET_PATH="E:\\Selenium Workspace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
static Workbook book;
static Sheet sheet;
public void switchToFrame()
{
	driver.switchTo().frame("mainpanel");
}

public static Object[][] getTestdata(String sheetName){
	FileInputStream file=null;
	try {
		file=new FileInputStream (TESTDATA_SHEET_PATH);
	}catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try{
		book=WorkbookFactory.create(file);
	}catch(InvalidFormatException e) {
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();
	}
	
	sheet=(Sheet) book.getSheet(sheetName);
	Object[][] data=new Object[((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum()][((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum()];
	for(int i=0;i<((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum();i++)
	{
		for(int k=0;k<((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0).getLastCellNum();k++)
		{
			data[i][k]=((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}

public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	//Files.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
}
}
