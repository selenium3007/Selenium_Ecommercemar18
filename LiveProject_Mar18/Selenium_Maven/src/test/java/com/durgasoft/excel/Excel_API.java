package com.durgasoft.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
	String filePath;

	public Excel_API(String file) throws Exception {
		this.filePath = file;
		fi = new FileInputStream(filePath);
		w = new XSSFWorkbook(fi);
		fi.close();
	}

	// Reading cell data from excel file by using column index
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			s = w.getSheet(sheetName);
			row = s.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "No matching value";
		}

	}

	// Reading cell data from excel file by using column name
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			s = w.getSheet(sheetName);
			row = s.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {

				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}
			row = s.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				return String.valueOf(cell.getNumericCellValue());
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}

		} catch (Exception e) {

			e.printStackTrace();
			return "No matching value";
		}
	}

	// Writing cell data from excel file by using column index
	public boolean setCellData(String sheetName, int colNum, int rowNum, String value) throws Exception {
		try {
			s = w.getSheet(sheetName);
			row = s.getRow(rowNum);
			if (row == null)
				row = s.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fo = new FileOutputStream(filePath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// Writing cell data from excel file by using column name
	public boolean setCellData(String sheetName, String colName, int rowNum, String value) throws Exception {
		try {
			s = w.getSheet(sheetName);
			row = s.getRow(0);
			int colNum = -1;
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}
			row = s.getRow(rowNum);
			if (row == null)
				row = s.createRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(value);
			fo = new FileOutputStream(filePath);
			w.write(fo);
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Identify no.of rows
	public int getRows(String sheetName) {
		s = w.getSheet(sheetName);
		int rowCount = s.getLastRowNum() + 1;
		return rowCount;

	}

	// Identify no.of columns
	public int getColumns(String sheetName) {
		s = w.getSheet(sheetName);
		row = s.getRow(0);
		int columnCount = row.getLastCellNum();
		return columnCount;
	}

}
