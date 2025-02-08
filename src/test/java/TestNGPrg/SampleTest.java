	package TestNGPrg;
	
	import org.testng.annotations.Test;
	
	
	public class SampleTest {
	
		@Test
		public void createContact()
		{
			System.out.println("contact Created");
		}
		
		@Test(enabled = false)
		public void modifyContact()
		{
			System.out.println("contact modified");
		}
		
		@Test
		public void deleteContact()
		{
			System.out.println("contact deleted");
		}
	}
	
	
