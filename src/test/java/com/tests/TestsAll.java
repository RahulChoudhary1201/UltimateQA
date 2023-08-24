package com.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.objects.FormPage;
import com.objects.HomePage;
import com.objects.ProductsPage;
import com.utils.ReadingExcelFiles;

public class TestsAll extends BaseTest {

	ReadingExcelFiles read = new ReadingExcelFiles();

	@Test(dataProvider = "myData")
	public void testHomePage(String name, String email, String jobTitle,
			String cName, String msg) throws InterruptedException, IOException {
		HomePage page = new HomePage(driver);
		page.clickPservices();
		FormPage pf = page.consultantBtnClick();
		pf.enteringCredentials(name, email, jobTitle, cName, msg);
		ProductsPage pPage = page.movingToLearningMenu();
		pPage.signInForm("rahul@gmail.com", "password@123");
		System.out.println(pPage.capturingErrorMsg());
		// pPage.navigatinBackToUrl();

	}

	@DataProvider(name = "myData")
	public Object[][] dataProvide() throws IOException {

		Object[][] data = read.readExcelFile(
				"C:\\Users\\2122119\\eclipse-workspace\\UltimateQA\\src\\main\\java\\com\\testdata",
				"TestData.xlsx", "Sheet1");
		Object[][] formattedData = new String[data.length - 1][data[1].length];
		// System.out.println("Row Count: " + data.length);
		// System.out.println("Col Count: " + data[0].length);
		// System.out.println(formattedData.length);
		for (int i = 1; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				formattedData[i - 1][j] = data[i][j];
			}
		}

		return formattedData;
	}

	// @Test(priority = 1, dataProvider = "myData")
	// public void excelRead(String name, String email, String jobTitle, String
	// companyName, String msg) {
	//
	// System.out.println(name + " " + email + " " + jobTitle + " " +
	// companyName + " " + msg);
	// }

}
