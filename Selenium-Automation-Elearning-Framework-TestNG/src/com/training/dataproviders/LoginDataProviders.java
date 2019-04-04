package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AddProductBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.UniformDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	/*
	 * @DataProvider(name = "db-inputs") public Object [][] getDBData() {
	 * 
	 * List<LoginBean> list = new ELearningDAO().getLogins();
	 * 
	 * Object[][] result = new Object[list.size()][]; int count = 0; for(LoginBean
	 * temp : list){ Object[] obj = new Object[9]; obj[0] = temp.getUserName();
	 * obj[1] = temp.getPassword();
	 * 
	 * result[count ++] = obj; }
	 * 
	 * 
	 * return result; }
	 */

	@DataProvider(name = "db-inputs")
	public Object[][] getDBData() {

		List<AddProductBean> list = new UniformDAO().getproductdetails();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (AddProductBean temp : list) {
			Object[] obj = new Object[9];
			obj[0] = temp.getProductname();
			obj[1] = temp.getMetatag();
			obj[2] = temp.getModel();
			obj[3] = temp.getPrice();
			obj[4] = temp.getQuantity();
			obj[5] = temp.getCategory();
			obj[6] = temp.getDiscountquantity();
			obj[7] = temp.getDiscountprice();
			obj[8] = temp.getPoints();

			result[count++] = obj;
		}

		return result;
	}

	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1() {
		String fileName = "C:/Selenium_TestData/TestData.xlsx";
		String sheetName = "UNF071";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
	}

	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2() {
		String fileName = "C:/Selenium_TestData/TestData.xlsx";
		String sheetName = "UNF072";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
	}

	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3() {
		String fileName = "C:/Selenium_TestData/TestData.xlsx";
		String sheetName = "UNF075";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData() {
		// ensure you will have the title as first line in the file
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1");
	}
}
