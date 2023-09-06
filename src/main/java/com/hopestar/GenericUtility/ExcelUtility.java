package com.hopestar.GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility {
	
	/**
	 * this method is used to read single data from excel
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname,int rowno,int cellno) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		String value=wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}
	
	/**
	 * this method is used to write data into the excel
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param data
	 * @throws Exception
	 */
	public void writeDataIntoExcel(String sheetname,int rowno,int cellno,String data) throws Exception
	{
		FileInputStream fi=new FileInputStream(IPathConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		wb.getSheet(sheetname).createRow(rowno).createCell(cellno).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelpath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * the method is used to get the last row num of the excel sheet
	 * @param sheetname
	 * @return
	 * @throws Exception
	 */
	public int getLastRowNo(String sheetname) throws Exception
	{
		FileInputStream fi=new FileInputStream(IPathConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		return count;
		
	}
	
	public HashMap<String,String> getMultipleDataFromExcel(String sheetname,int keycellno,int valuecellno,WebDriver driver) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.excelpath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetname);
		int count=sh.getLastRowNum();
		
		HashMap<String,String> map=new HashMap<String,String>(); // empty map to store key value pair
		for(int i=0;i<=count;i++)
		{
			
			String key=sh.getRow(i).getCell(keycellno).getStringCellValue();
			String value=sh.getRow(i).getCell(valuecellno).getStringCellValue();
			map.put(key, value);
		}
	
		for(Entry<String,String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			Thread.sleep(500);
		}
	    return map;	
	  }
	
	
       //Dataprovider method	
     	public Object[][] DPMultipleSetOfData(String sheetname) throws Throwable
     	{
     		File file=new File(IPathConstants.excelpath);
    		FileInputStream fis=new FileInputStream(file);
    		Workbook wb = WorkbookFactory.create(fis);
    		Sheet sh = wb.getSheet(sheetname);
    		int rowcount=sh.getLastRowNum();
    		int cellcount=sh.getRow(1).getLastCellNum();
//    		System.out.println(rowcount);
//    		System.out.println(cellcount);
    		
    		Object[][] obj=new Object[rowcount][cellcount];
    		for(int i=1;i<=rowcount;i++)
    		{
    			for(int j=0;j<cellcount;j++)
    			{
    				obj[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
    			}
    		}
    		return obj;
    		
    	}
     	
   }
	
	


