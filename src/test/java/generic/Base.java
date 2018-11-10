package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;

public class Base {
public void readFile(String filename) {
	String ext=".xlsx";
	String path="\\src\\test\\java\\data\\";
	path=this.getCurrentDirectorypathandConcat(path+filename+ext);
	File file=new File(path);
	try {
		FileInputStream fis=new FileInputStream(file);
	
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sample"); 
		XSSFRow row=sheet.getRow(0);
		for(int i=0;i<100;i++)
		{
		
		XSSFCell cell=row.getCell(i);
		System.out.println(cell.getStringCellValue());
		
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}

public void compareValue(Object actual_value, Object expected_value) {
	Assert.assertEquals("Values are not matching", expected_value, actual_value);
		
}
public String getCurrentDirectorypathandConcat(String path) {
	String currentPath=System.getProperty("user.dir");

	currentPath=currentPath+path;
	return currentPath;
	
}
public void writeFile(String filename) {
	String ext=".xlsx";
	String path="\\src\\test\\java\\data\\";
	@SuppressWarnings("resource")
	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet sheet=wb.createSheet("Sample"); 
	XSSFRow row=sheet.createRow(0);
	for(int i=0;i<100;i++)
	{
	
	XSSFCell cell=row.createCell(i);
	cell.setCellValue("Sannidhi");
	}
	path=this.getCurrentDirectorypathandConcat(path+filename+ext);
	
	
	File file=new File(path);
	try {
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	
}
	
