package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PomEx {

	public PomEx(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(xpath = "//input[@title=\"Search for Products, Brands and More\"]"), @FindBy(xpath = "//input[@type=\"text\"]") })
	private WebElement searchBar;
	
	@FindBys({@FindBy(xpath = "//input[@type=\"text\"]"),@FindBy(xpath = "//input[@title=\"Search for Products, Brands and More\"]")})
	private WebElement search;
	

	@FindAll({ @FindBy(css = "[type=\"submit\"]"),
			@FindBy(xpath = "//button[@aria-label=\"Search for Products, Brands and More\"]") })
	private WebElement searchIcon;

	
	
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public void enterValue(String value) {
		search.sendKeys(value);
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}

}
