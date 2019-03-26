package com.crm.qa.util;

import java.io.IOException;

public class ExcelTest {

	public static void main(String[] args) {

		try {
			ExcelOperationsUsingPOI.readExcel("C:\\Users\\raghuveer.mh\\eclipse-workspace\\FreeCrm\\src\\main\\java\\com\\crm\\qa\\testdata", "FreCRM.xlsx", "Contacts");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
