package StepDefinations;

import PlayWrightMethods.PlayWrightMethods;
import io.cucumber.java.en.Given;

public class Flipkart {
	PlayWrightMethods playWrightMethods=new PlayWrightMethods();
	@Given("I launch Flipkart")
	public void i_launch_flipkart() {
		playWrightMethods.launchBrowser();
		playWrightMethods.lauchUrl("https://www.toolsqa.com");
		playWrightMethods.closeBrowser();
		playWrightMethods.closePlayWright();
	}
}
