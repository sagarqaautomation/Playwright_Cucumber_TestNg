package StepDefinations;

import PlayWrightMethods.PlayWrightMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Amazon {

	PlayWrightMethods playWrightMethods=new PlayWrightMethods();
	
	@Given("I launch Amazon")
	public void i_launch_amazon() {
		playWrightMethods.launchBrowser();
		playWrightMethods.lauchUrl("https://www.amazon.in");
	}

	@When("I check element is visible")
	public void i_check_element_is_visible() {
		playWrightMethods.checkElementIsEnable();
		playWrightMethods.checkElementIsVisible();
	}

	@When("I check element is selectable")
	public void i_check_element_is_selectable() {
		playWrightMethods.checkElementIsEnable();
	}

	@When("I get title")
	public void i_get_title() {
		playWrightMethods.getTitle();
		playWrightMethods.closeBrowser();
		playWrightMethods.closePlayWright();
	}
}
