package com.project.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	
	
public static final int IMPLICIT_WAIT_Time=10;	
	
public static final int PAGE_LOAD_Time=30;		
	
	
	
	
	public static  String  generateEmailWithTimeStamp() {
		Date date = new Date();
		String TimeStamp= date.toString().replace(" ", "_").replace(":", "_");
		return "akshatachinake99"+TimeStamp+"@gmail.com";
	//This Method Is required in Login and Register Class as well, Then Why To write It again again instead of it 
	// we will create a package in src/main/java utilities will paste in that 
			
	}	
	
	
//To Read The Data From XCEL FILE
	
	public static Object[][] getTestDataFromExcel(String sheetName) {// This method retuns Two dimnetinal Objecr Array 
		
	
		
		
		
	// The code below is to refer ExcelFile usd in project to this code 	
		
		
		
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsNinja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null ;
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		// The Code below  is Code to Read ExcelFile 
	 workbook = new XSSFWorkbook(fisExcel);//Specified WorkExcel
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		
         XSSFSheet sheet=workbook.getSheet(sheetName);//returns SheetName 
         
		//To Find How Many numbers of Rows And coloumn in That Sheet 
         
        int rows = sheet.getLastRowNum();//This is PreDefined Method To get Row ; 4 Rows are There 
		int colmns= sheet.getRow(0).getLastCellNum();// This gives Total no of colmns
		
		Object[][] data = new Object [rows][colmns];//create a Two Dimentinal Object Array 
		
		for( int i=0;i<rows;i++) {
			 
		XSSFRow row =	sheet.getRow(i+1);//returns XSSFRow ; i will read Email but we want to read data onwards so write i+1
		
		   for (int j=0;j<colmns;j++) {
		    XSSFCell cell =	   row.getCell(j);// it returns XSSFcolmns
//But Cell Values Are Diffrent type Email is String And Password is Number 
		    
	CellType 	cellType  =   cell.getCellType();// it Gives CellType
		
		    switch(cellType) {
		    
		    case STRING:
		       
		       data [i][j]=cell.getStringCellValue();
		       break;
		    
		    case NUMERIC:
		    	// data [i][j]= cell.getNumericCellValue();// but it gives value with point added and tht is not a password so...
		    	//typecast to int and convert to string  
		    	data [i][j]= Integer. toString ((int)cell.getNumericCellValue());
		     break;
		     
		    case BOOLEAN:
		    	
		    	   data [i][j]=cell.getBooleanCellValue();
		     
		           break;
		    }
		    
		    
		    
		   }
		
		
		
		
			
			
		}
		
		return data;	
		
	}
	
	public  static String  captureScreenShotMethod(WebDriver driver, String testName) {
		
		File srcScreenShot =	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenShotPath= System.getProperty("user.dir"+"\\ScreenShot\\"+testName+".png");
		try {
			FileHandler.copy(srcScreenShot, new File(destinationScreenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return destinationScreenShotPath;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
