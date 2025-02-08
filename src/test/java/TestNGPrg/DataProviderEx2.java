package TestNGPrg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {

	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int numOfPpl) {
		System.out.println("Book Tickets from  " + src + " to " + dest + numOfPpl);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[2][3];

		objArr[0][0] = "Banglore";
		objArr[0][1] = "goa";
		objArr[0][2] = 10;

		objArr[1][0] = "Banglore";
		objArr[1][1] = "mumbai";
		objArr[1][2] = 20;

		return objArr;

	}
}
