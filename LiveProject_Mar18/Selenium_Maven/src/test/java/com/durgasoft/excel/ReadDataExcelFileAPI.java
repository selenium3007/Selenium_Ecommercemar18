package com.durgasoft.excel;

import org.testng.annotations.Test;

public class ReadDataExcelFileAPI {
	@Test
	public void f() throws Exception {
		Excel_API e = new Excel_API("D:\\LiveProject_Mar18\\Selenium_Maven\\testdata\\login.xlsx");
		/*System.out.println(e.getCellData("Sheet1", 1, 2));
		System.out.println(e.getCellData("Sheet1", "Results", 2));
		System.out.println(e.setCellData("Sheet1", 2, 5, "PASSED"));
		System.out.println(e.setCellData("Sheet1", "Results", 4, "SKIPPED"));*/
		System.out.println(e.getRows("Sheet1"));
		System.out.println(e.getColumns("Sheet1"));
		
	}
}
