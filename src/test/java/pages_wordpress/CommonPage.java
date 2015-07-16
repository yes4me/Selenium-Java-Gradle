package pages_wordpress;

import lib.BasePage;

import org.openqa.selenium.WebDriver;

import config.Paths;

public class CommonPage extends BasePage {
	private static final String PARTIAL_URL = "/wp-login.php?loggedout=true";

	public CommonPage(WebDriver driver) {
		super(driver);
	}
	public void Logout() {
		visit(Paths.WORDPRESS_URL + PARTIAL_URL);
	}
}
