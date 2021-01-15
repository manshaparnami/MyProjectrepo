package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class execution {
	 List <String> headervalues= null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		execution obj = new execution();
		// TODO Auto-generated method stub
		/*TestCommands obj = new TestCommands();
		obj.readconfig("browser");
		obj.initWebdriver();
		obj.launchBrowser();
		SalesforceCommands obj2 = new SalesforceCommands();
		obj2.Login();
		obj2.createAccount();*/
		
		/*Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		Date nextYear = cal.getTime();
		System.out.println("Date value"+nextYear.toString());*/
		
		/*Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		System.out.println(formatter.format(date));*/
		
		/*Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		//System.out.println(today.getYear());
	    cal.add(Calendar.YEAR, 1);
	    Date nextYear = cal.getTime();
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

	    String date1 = format1.format(nextYear);
	    System.out.println("next year date is "+ date1);*/
		
		//obj.ValidateDate();
	
	
	
	/*public String CloseDate(String CloseDate) {
	
	
	Calendar cal = Calendar.getInstance();
	Date today = cal.getTime();
	//System.out.println(today.getYear());
    cal.add(Calendar.YEAR,1);
    Date nextYear = cal.getTime();
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

    String date1 = format1.format(nextYear);
    System.out.println("next year date is "+ date1);
    
    return date1;
	}
	public void ValidateDate() {
		String OneYearDate = "2021-01-01";
		String getOneYearDate = CloseDate("Test");
	}
	*/
obj.readExcel("C:\\Users\\Appirio-10998\\Documents","ReadExcelAssignment.xlsx", "FirstSheet");
	}
	

public void readExcel(String filePath,String fileName,String sheetName) throws IOException
{

    //Create an object of File class to open xlsx file

    File file =    new File(filePath+"\\"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook myWorkbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    myWorkbook = new XSSFWorkbook(inputStream);

    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

        myWorkbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet mySheet = myWorkbook.getSheet(sheetName);
    		

    //Find number of rows in excel file
    System.out.println("Last row :"+mySheet.getLastRowNum() + "First Row is :"+mySheet.getFirstRowNum());

    int rowCount = mySheet.getLastRowNum()-mySheet.getFirstRowNum();
    System.out.println("Total rows:"+ rowCount);

    //Create a loop over all the rows of excel file to read it
    
    List<Double> x1Data = new ArrayList<Double>();
    List<Double> x2Data = new ArrayList <Double>();
    List<Double> x9Data = new ArrayList <Double>();
    List<Double> x10Data = new ArrayList <Double>();
    List<Double> x11Data = new ArrayList <Double>();
    List<Double> x12Data = new ArrayList <Double>();
  
    
    for (int i = 0; i < rowCount+1; i++) {

        Row row = mySheet.getRow(i);
        
        if(i==0) {
        	 headervalues= new ArrayList<String>();
        	 for (int j = 0; j < row.getLastCellNum(); j++) {
        		 headervalues.add(row.getCell(j).getStringCellValue());
        		
        	 }
        	 continue;
        }
        
        
        int indexrequired =  headervalues.indexOf("X1");
        int indexofx2 = headervalues.indexOf("X2");
        int indexofx9 = headervalues.indexOf("X9");
        int indexofx10 = headervalues.indexOf("X10");
        int indexofx11 = headervalues.indexOf("X11");
        int indexofx12 = headervalues.indexOf("X12");
        
        x1Data.add(row.getCell(indexrequired).getNumericCellValue());
        x2Data.add(row.getCell(indexofx2).getNumericCellValue());
        x9Data.add(row.getCell(indexofx9).getNumericCellValue());
        x10Data.add(row.getCell(indexofx10).getNumericCellValue());
        x11Data.add(row.getCell(indexofx11).getNumericCellValue());
        x12Data.add(row.getCell(indexofx12).getNumericCellValue());
        
  //  System.out.println("X1 data:"+row.getCell(indexrequired).getNumericCellValue());

    }
    System.out.println("X1 data :"+x1Data);
    System.out.println("X2 data :"+x2Data);
    for(int i=0;i<x1Data.size();i++) {
    	if(x1Data.get(i)+x10Data.get(i)==x11Data.get(i) && x2Data.get(i)+x9Data.get(i)==x12Data.get(i)) {
    		System.out.println("Test case is passed , values are correct");
    	}
    	else 
    	{
    		System.out.println("Values are incorrect");
    	}
    }
}
}