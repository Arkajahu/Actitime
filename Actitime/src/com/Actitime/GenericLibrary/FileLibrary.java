package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 *  this method is a generic m,ethod which is used to read data from property file.
 * @author Jspiders thane1
 *
 */
public class FileLibrary {
	/**
	 * this method is a generic method which is used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
		public String readDataFromProperty(String key) throws IOException {
			FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
			Properties p=new Properties();
			p.load(fis);
			String value = p.getProperty(key);
			return value;
			
		}
		/**
		 * This method is a generic method used to read data from excel sheet.
		 * @param sheet
		 * @param row
		 * @param cell
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./Testdata/BANKINGInfo.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			return value;
			
		}
}
