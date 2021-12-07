package com.numpy_ninja.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {

	public static FileInputStream fileInput;
	public static FileOutputStream fileoutput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getrowcount(String excelpath,String sheetname) throws IOException
	{
	  fileInput = new FileInputStream(excelpath);
	  workbook = new XSSFWorkbook(fileInput);
	  sheet = workbook.getSheet(sheetname);
	  int rowcount =sheet.getLastRowNum();  
	  workbook.close();
	  fileInput.close();
	  return rowcount;
	}
	
	public static int getcellcount(String excelpath ,String sheetname,int rownumber) throws IOException
	{
		
	     fileInput = new FileInputStream(excelpath);
		 workbook = new XSSFWorkbook(fileInput);
		 sheet = workbook.getSheet(sheetname);
		 row = sheet.getRow(rownumber);
		 int cellcount = row.getLastCellNum();
		 workbook.close();
		 fileInput.close();
		 return cellcount;
		
		
	}
	
	
	public static String getcelldata(String excelpath,String sheetname,int rownumber,int colnumber) throws IOException
	{
		
	     fileInput = new FileInputStream(excelpath);
		 workbook = new XSSFWorkbook(fileInput);
		 sheet = workbook.getSheet(sheetname);
		 row = sheet.getRow(rownumber);
		 cell= row.getCell(colnumber);
		
		 DataFormatter formatteddata = new DataFormatter();
		 String data ;
		 try {
		 data = formatteddata.formatCellValue(cell);
		 }
		 catch (Exception e)
		 {
			 data =" ";
		 }
		 workbook.close();
		 fileInput.close();
		 return data;
		
		
	}
	
	
	public static void writecelldata (String excelpath,String sheetname,int rownumber,int colnumber,String data) throws IOException
	{
		fileInput = new FileInputStream(excelpath);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetname);
		System.out.println(excelpath+sheetname+rownumber+colnumber);
		
		row = sheet.getRow(rownumber);
		cell = row.createCell(colnumber);
		cell.setCellValue(data);
		
		fileoutput =new FileOutputStream(excelpath);
		workbook.write(fileoutput);
		workbook.close();
		 
		fileInput.close();
		fileoutput.close();
		
	}
	
	
	
}
