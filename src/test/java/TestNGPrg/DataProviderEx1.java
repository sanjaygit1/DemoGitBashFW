package TestNGPrg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest) {
		System.out.println("Book Tickets from  " + src + " to " + dest);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[2][2];

		objArr[0][0] = "Banglore";
		objArr[0][1] = "goa";

		objArr[1][0] = "Banglore";
		objArr[1][1] = "mumbai";

		return objArr;

	}
}
