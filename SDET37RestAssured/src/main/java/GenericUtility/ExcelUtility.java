package GenericUtility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author nithin
 *
 */
public class ExcelUtility {

	/**
	 * this method is used to read data from the excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String toReadDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter data = new DataFormatter();
		String value = data.formatCellValue(cell);
		return value;
	}
	/**
	 * to write the data to excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void toWriteTheDataToExcelFile(String sheetName,int rowNum,int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(IConstants.excelPath);
		workbook.write(fileOutputStream);
	}
	/**
	 * this method will return the last row number
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int toGetLastRowNumber(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fileInputStream = new FileInputStream(IConstants.excelPath);
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		return row;
	}
}

