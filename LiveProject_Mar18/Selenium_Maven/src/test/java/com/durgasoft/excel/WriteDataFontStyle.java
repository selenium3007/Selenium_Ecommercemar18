package com.durgasoft.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataFontStyle {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFFont font;
	public XSSFCellStyle style;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\LiveProject_Mar18\\Selenium_Maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		row = null;
		cell = null;
		font = w.createFont();
		style = w.createCellStyle();
		row = s.getRow(5);
		if (row == null)
			row = s.createRow(5);
		if (cell == null)
			cell = row.createCell(2);
		font.setFontName("Arial Black");
		font.setBold(true);
		font.setFontHeight(8);
		style.setFont(font);
		cell.setCellStyle(style);
		cell.setCellValue("PASSED");
		fo = new FileOutputStream("D:\\LiveProject_Mar18\\Selenium_Maven\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
	}

}
