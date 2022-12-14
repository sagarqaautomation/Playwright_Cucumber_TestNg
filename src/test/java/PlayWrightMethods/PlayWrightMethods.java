package PlayWrightMethods;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;

public class PlayWrightMethods {
	
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	public Playwright setPlayWrightServer()
	{
		return playwright = Playwright.create();		
	}
	
	public Browser setBrowser()
	{
//		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
//		int width=(int)screenSize.getWidth();
//		int height=(int)screenSize.getHeight();
//		return browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
//				  .setArgs(Arrays.asList("--start-maximized")).setHeadless(false));
		// browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		// return context=browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		
		return browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
				  .setArgs(Arrays.asList("--start-maximized")).setHeadless(false));
	}
	
	
	
	public Page setPage()
	{
		return page = browser.newPage();
	}
	
	public void launchBrowser()
	{
		setPlayWrightServer();
		setBrowser();
		setPage();
		page.setViewportSize(1920, 1280);
		
		
	}
	
	public void lauchUrl(String url)
	{
		page.navigate(url);
	}
	
	public void getTitle()
	{
		System.out.println(page.title());
	}
	
	public void checkElementIsVisible()
	{
		boolean check=page.isVisible("//a[text()='Sign in securely']");
		if(check) System.out.println("element is visible");
		else System.out.println("element is not visible");
	}
	
	public void checkElementIsEnable()
	{
		boolean check=page.isEnabled("//a[text()='Sign in securely']");
		if(check) System.out.println("element is enabled");
		else System.out.println("element is not disable");
	}
	
	public void findElement(String selector)
	{
		page.locator(selector);
	}
	
	
	public void findElementByLabel(String selector)
	{
		page.getByLabel(selector);
	}
	
	public void returnMultipleElements(String selector)
	{
		Locator multipleElements=page.locator(selector);
		List<String> list=multipleElements.allTextContents();
		for(String listOfElements : list)
			System.out.println(listOfElements);
	}
	
	//for radio and checkbox buttons
	public void selectCheckbox_RadioButton(String selector)
	{
		page.locator(selector).check();
	}
	
	public void verifyCheckbox_RadioButton(String selector)
	{
		page.locator(selector).isChecked();
	}
	
	public void selectDropdownValue(String selector,String value)
	{
		page.locator(selector).selectOption(value);
	}
	
	public void selectDropdownByLabel(String selector,String labelName)
	{
		page.getByLabel(selector).selectOption(labelName);
	}
	
	public void selectMultipleDrownValues(String selector,String[] dropdownValues)
	{
		page.locator(selector).selectOption(dropdownValues);
	}
	
	
	public void doubleClick(String selector)
	{
		page.locator(selector).dblclick();
	}
	
	public void clickElement(String selector)
	{
		page.locator(selector).click();
	}
	
	public void mouseHover(String selector)
	{
		page.locator(selector).hover();
	}
	
	public void forceClick(String selector)
	{
		page.locator(selector).click(new Locator.ClickOptions().setForce(true));
	}
	
	public void rightClick(String selector)
	{
		page.locator(selector).click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
	}
	
	public void closeBrowser()
	{
		page.close();
	}
	
	public void closePlayWright()
	{
		playwright.close();
	}
	
	public void uploadFile(String selector,String fileName)
	{
		page.locator(selector).setInputFiles(Paths.get(fileName));		
	}
	
	public void DragAndDrop(String source,String Destination)
	{
		page.locator(source).dragTo(page.locator(Destination));
	}
	
	public void assertions(String assertType,Locator locator,String value,String[]Values)
	{
		switch(assertType)
		{
		case"NotEqual":
			assertThat(locator).not().containsText(value);
			break;
		case"IsChecked":
			assertThat(locator).isChecked();
			break;
		case"IsDisabled":
			assertThat(locator).isDisabled();
			break;
		case"IsEditable":
			assertThat(locator).isEditable();
			break;
		case"IsEmpty":
			assertThat(locator).isEmpty();
			break;
		case"IsEnabled":
			assertThat(locator).isEnabled();
			break;
		case"IsFocused":
			assertThat(locator).isFocused();
			break;
		case"IsHidden":
			assertThat(locator).isHidden();
			break;
		case"IsVisible":
			assertThat(locator).isVisible();
			break;
		case"containsText":
			assertThat(locator).containsText(value);
			break;
		case"containsMultipleText":
			assertThat(locator).containsText(Values);
			break;
		}
		
	}
	
	//click button inside the frame
	public void switchtoFrame(String selector,String selector2)
	{
		page.frame(selector).locator(selector2).click();
		
		// or
		
		page.frameLocator(selector).locator(selector2).click();
		 
	}
	}
