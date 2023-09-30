package com.ActiTime.GenricLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is a genric class which contains  non static to read data from property and excel file.
 * @author avina
 *
 */
public class fileLibrary {
	/**
	 * this method is a non static method used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */

public String readDataFromPropertyFile(String key) throws IOException {
	
	FileInputStream fis=new FileInputStream("./Testdata/commandata.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;	
}
/**
 * 
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./Testdata/BANKINGinfo.xisx.xlsx");
	Workbook wb =WorkbookFactory.create(fis);
	String value=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return value;
	
}
}