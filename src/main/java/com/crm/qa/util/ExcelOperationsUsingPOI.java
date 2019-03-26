package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperationsUsingPOI {
	
	public static void readExcel(String filePath,String filename, String sheetname) throws IOException {
		
		 //Create a object of File class to open xlsx file
		File file = new File(filePath+"\\"+filename);
		
		//Create an object of FileInputStream class to read excel file
		
		FileInputStream ip = new FileInputStream(file);
		
		Workbook myWorkBook =  null;
		
		//Find the file extension by spliting file name in substring and getting only extension name
        //indexOf gives the index of . in the file name
        //substring method splits the string starting from index of . to the end
		
		String fileExtension = filename.substring(filename.indexOf("."));
		
		//Check condition if the file is xlsx file
		
		if(fileExtension.equals(".xlsx")) {
			 //If it is xlsx file then create object of XSSFWorkbook class
			myWorkBook = new XSSFWorkbook(ip);
		}
		
		 //Check condition if the file is xls file
		else if(fileExtension.equals(".xls")) {
			 //If it is xls file then create object of HSSFWorkbook class
			myWorkBook = new HSSFWorkbook(ip);
		}
		
		//Read sheet inside the workbook by its name
		Sheet sheetName = myWorkBook.getSheet(sheetname);
		
		//Find number of rows in excel file
		
		int rowCount = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
		
		 //Create a loop over all the rows of excel file to read it
		for(int i=0; i<rowCount+1;i++) {
			Row row = sheetName.getRow(i);
			//Create a loop to print cell values in a row
			for(int j=0;j<row.getLastCellNum();j++) {
				 //Print excel data in console
				System.out.println(row.getCell(j).getStringCellValue()+" ");
			}
			System.out.println();
			
		}
		
		
		
		
		
		
	}
	

}
