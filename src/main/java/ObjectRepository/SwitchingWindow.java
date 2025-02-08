package ObjectRepository;

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindow {

	public SwitchingWindow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement prdPlusSign;

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement name;

	@FindBy(name = "search")
	private WebElement searchPrd;

	public void clickPrdPlus() {
		prdPlusSign.click();
	}

	public void enterPrdName(String namePrd) {
		name.sendKeys(namePrd);
	}

	public void searchPrdName()

	{
		searchPrd.click();
	}

	public void dynamicPath(WebDriver driver, String PrdName) {
		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();
	}
}
