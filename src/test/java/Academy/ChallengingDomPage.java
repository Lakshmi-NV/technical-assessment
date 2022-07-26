package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ChallengingDom;
import resources.base;


public class ChallengingDomPage extends base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{
		driver =initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	}

	@Test
	public void ValidateBlueButton() throws IOException, InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		String TextBeforeClick = c.getBlueText().getText();
		System.out.println(TextBeforeClick);
		String Canvas1 = c.validateCanvas();
		c.clickBlueText();

		String TextAfterClick = c.getBlueText().getText();
		System.out.println(TextAfterClick);
		String Canvas2 = c.validateCanvas();

		Assert.assertNotEquals(TextBeforeClick, TextAfterClick);
		Assert.assertNotEquals(Canvas1,  Canvas2);
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void validateAppTitle() throws IOException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.getTitle().getText(), "Challenging DOM");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void ValidateParagraphText() throws IOException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.getParagraphText().getText(), "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element.");
		System.out.println(c.getParagraphText().getText());
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void ListTableData() throws IOException
	{
		ChallengingDom c=new ChallengingDom(driver);
		c.listTableData();
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void NoofRowsandColumn() throws IOException
	{
		ChallengingDom c=new ChallengingDom(driver);
		c.noofRowsandColumn();
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void TestCanvas() throws IOException, InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		c.validateCanvas();
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void VerifyButton() throws IOException
	{
		//SoftAssert softassert = new SoftAssert();
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertTrue(c.verifyBlueButton());
		System.out.println("Blue Button Verified");
		Assert.assertTrue(c.verifyRedButton());
		System.out.println("Red Button Verified");
		Assert.assertTrue(c.verifyGreenButton());
		System.out.println("Green Button Verified");

		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void VerifyElementalSelenium() throws IOException, InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.clickElementalSelenium(), "http://elementalselenium.com/");
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	
	public void VerifyForkMeOnGithub() throws IOException, InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.clickForkMeonGitHUb(), "https://github.com/saucelabs/the-internet");
		driver.navigate().back();
		Thread.sleep(1000);
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void ValidateEditButton() throws InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.clickEdit(), "https://the-internet.herokuapp.com/challenging_dom#edit");
		driver.navigate().back();
		Thread.sleep(1000);
		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@Test
	public void ValidateDeleteButton() throws InterruptedException
	{
		ChallengingDom c=new ChallengingDom(driver);
		Assert.assertEquals(c.clickDelete(), "https://the-internet.herokuapp.com/challenging_dom#delete");
		driver.navigate().back();
		Thread.sleep(1000);

		log.info("Successfully validated Text message");
		System.out.println("Test completed");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
