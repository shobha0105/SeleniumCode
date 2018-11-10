//Program to create an excel file, write values from virtual excelworkbook, read excel and write to text file

package com.inportia.automation_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IOclass {
	//ArrayList<E> arr=new ArrayList<E>();
	int i=0;
	
	public String getcurrentdirectoryandfilepath(String path) {
		String currentpath=System.getProperty("user.dir");
		currentpath=currentpath+path;
		return currentpath;
		
	}
	
	
	public void writeToTextfileFromXLFile(String file1, String file2) {
		//file1 is excel file and filed2 is txt file
		
		FileInputStream fis = null;
		String ext2=".txt";
		String ext1=".xlsx";
		
		String path="\\src\\test\\java\\data\\";
		path=this.getcurrentdirectoryandfilepath(path+file1+ext1); //excelfile
		File file=new File(path);
		
	    try {
	    	fis = new FileInputStream(file);
		
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    XSSFSheet sheet = workbook.getSheetAt(0); // first sheet of Excel file
		    Iterator<Row> rows = sheet.rowIterator();
		    //---
		    String path1="\\src\\test\\java\\data\\";
		    path1=this.getcurrentdirectoryandfilepath(path1+file2+ext2); //textfile
		   // System.out.println(path1);
	
				File f=new File(path1); //text file path
			
				FileOutputStream fos=new FileOutputStream(f); 

		    while (rows.hasNext()) {
		        XSSFRow row1 = (XSSFRow) rows.next();
		        
		        
		        Iterator<Cell> cells = row1.cellIterator();
		        
		       
		        while (cells.hasNext()) {
		            XSSFCell cell1 = (XSSFCell) cells.next();
		            //arr.add((E) cell1);
		            String content=cell1.getStringCellValue(); //assign  each cell value to content String variable       
		            byte[] contentInBytes = content.getBytes(); //got each string into bytes
					fos.write(contentInBytes); //wrote each byte to txt file
					fos.flush();
					//fos.close();
		             
		             //System.out.println("'"+cell1.getStringCellValue()+"',");
		        }
		       
		    }
		    
	    }
	    

		 catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	    
		} 
	     

	
public 	void readFile(String filename) {
		String ext=".xlsx";
		String path="\\src\\test\\java\\data\\";
		path=this.getcurrentdirectoryandfilepath(path+filename+ext);
		
		File file=new File(path);
		try {
			FileInputStream fin=new FileInputStream(file);
			XSSFWorkbook wb= new XSSFWorkbook(fin);
			XSSFSheet sheet=wb.getSheet("sample");
			XSSFRow row=sheet.getRow(0);
			for(int i=0;i<50;i++) {
				XSSFCell cell=row.getCell(0);
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
	public void writeFile(String filename) throws IOException {
		String ext=".xlsx";
		String path="\\src\\test\\java\\data\\";
		path=this.getcurrentdirectoryandfilepath(path+filename+ext);
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("sample");
		XSSFRow row=sheet.createRow(0);
		for(i=0;i<50;i++) {
			XSSFCell cell=row.createCell(i);
			String str="This is the cell value "+String.valueOf(i);
			cell.setCellValue(str);	
			System.out.println("i " +i+ "\n");
		}
		
		// Pass the filepath in File object
		File file=new File(path);
		//Pass file object in Fileoutputstream ; with this write virtual workbook data to actual physical file 
		FileOutputStream fos=new FileOutputStream(file);
		//write virtual workbook data to file
		wb.write(fos);
		
		
		
		/*try {
			//wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}

		
