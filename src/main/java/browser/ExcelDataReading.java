//Excel Data reading to program. 

package browser;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

//Excel file import 
public class ExcelDataReading {
	
	static WebDriver driver;
	FileInputStream fileReading;
	XSSFWorkbook workbookForScript1;
	HSSFWorkbook workbookforScript2;
	
	XSSFSheet sheetDetailsForScript;
	String data1,data2,object1,object2,data3;
	
	 @BeforeClass
		public static void setUpBeforeClass() throws Exception {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\namita.koni\\Desktop\\SeleniumAdv\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			}
	 
  @Test
  public void test() throws IOException{
	  String filepath = "C:\\Users\\namita.koni\\Desktop\\SeleniumAdv\\testdata.xlsx";
	  File fileforScript = new File(filepath);
	 
	  FileInputStream fileInputStreamForScript = new FileInputStream(fileforScript);
		  
		  
		  if(filepath.contains("xlsx")) {
			  workbookForScript1 = new XSSFWorkbook(fileInputStreamForScript);
		  }
		  else {
			  workbookforScript2 = new HSSFWorkbook(fileInputStreamForScript);
		  }
		sheetDetailsForScript = workbookForScript1.getSheetAt(0);
		int rows = sheetDetailsForScript.getPhysicalNumberOfRows();
		System.out.println("The number of rows filled  "+rows);
		driver.get("http://www.newtours.demoaut.com/");
		driver.manage().window().maximize();
		data1 = sheetDetailsForScript.getRow(1).getCell(0).getStringCellValue();
		System.out.println(data1);
		data2 = sheetDetailsForScript.getRow(2).getCell(0).getStringCellValue();
		System.out.println(data2);
		object1 = sheetDetailsForScript.getRow(1).getCell(1).getStringCellValue();
		System.out.println(object1);
		object2 = sheetDetailsForScript.getRow(2).getCell(1).getStringCellValue();
		System.out.println(object2);
		driver.close();
		  
  }

}
