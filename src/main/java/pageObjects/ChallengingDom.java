package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDom {

	public WebDriver driver;

	By challengingDom=By.xpath("//h3[contains(text(),'Challenging DOM')]");
	By forkMeOnGithub=By.xpath("//img[contains(@alt, 'Fork me on GitHub')]");
	By hardestPartPara=By.xpath("//p[contains(text(),'The hardest part in automated web testing is findi')]");
	By blueButton=By.xpath("//a[@class='button']");
	By redButton=By.xpath("//a[@class='button alert']");
	By greenButton=By.xpath("//a[@class='button success']");
	By tbHeader1=By.xpath("//thead//tr//th[1]");
	By tbHeader2=By.xpath("//thead//tr//th[2]");
	By tbHeader3=By.xpath("//thead//tr//th[3]");
	By tbHeader4=By.xpath("//thead//tr//th[4]");
	By tbHeader5=By.xpath("//thead//tr//th[5]");
	By tbHeader6=By.xpath("//thead//tr//th[6]");
	By tbHeader7=By.xpath("//thead//tr//th[7]");
	By identifyTable=By.xpath("//table[1]");
	By canvas=By.xpath("//canvas[@id='canvas']");
	By elementalSelenium=By.xpath("//a[contains(text(),'Elemental Selenium')]");
	By headerElementalSelenium=By.xpath("//h1[contains(text(),'Elemental Selenium')]");
	By lblSauceLabs=By.xpath("//a[contains(text(),'Sauce Labs')]");
	By editButton=By.xpath("//tbody/tr[1]/td[7]/a[1]");
	By deleteButton=By.xpath("//tbody/tr[1]/td[7]/a[2]");


	public ChallengingDom(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getTitle()
	{
		return driver.findElement(challengingDom);
	}

	public WebElement getParagraphText()
	{
		return driver.findElement(hardestPartPara);
	}

	public WebElement listTableData()
	{
		//To locate table.
		WebElement mytable = driver.findElement(identifyTable);

		//To locate rows of table. 
		List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));

		//To calculate no of rows In table.
		int rows_count = rows_table.size();

		//Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {

			//To locate columns(cells) of that specific row.
			List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			//To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			//Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {

				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();
				System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);

			}
			System.out.println("-------------------------------------------------- ");
		}
		return mytable;
	}

	public WebElement noofRowsandColumn()
	{
		WebElement mytable = driver.findElement(identifyTable);

		//No.of rows 
		List <WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr")); 
		System.out.println("No of rows are : " + rows.size());

		//No.of Columns
		List <WebElement> col = driver.findElements(By.xpath("//thead/tr/th"));
		System.out.println("No of cols are : " +col.size()); 

		return mytable;
	}

	public String validateCanvas() throws InterruptedException
	{
		String canvasno = new String();

		ArrayList<WebElement>scripts = new ArrayList<WebElement>((ArrayList<WebElement>) driver.findElements(By.tagName("script")));

		for(int i = 0; i < scripts.size(); i++) {

			String focusText = scripts.get(i).getAttribute("innerHTML");
			Thread.sleep(5000);

			if(focusText.contains("canvas.strokeText")) {

				canvasno = focusText.substring(focusText.indexOf("Answer"), focusText.indexOf("',"));
				driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				System.out.println(canvasno);
				break;

			}
		}
		return canvasno;

	}


	public boolean verifyBlueButton()
	{
		return driver.findElement(blueButton).isDisplayed();

	}

	public boolean verifyRedButton()
	{
		return driver.findElement(redButton).isDisplayed();

	}

	public boolean verifyGreenButton()
	{
		return driver.findElement(greenButton).isDisplayed();

	}

	public WebElement getBlueText()
	{
		return driver.findElement(blueButton);
	}

	public WebElement getButtonText(By xpath)
	{
		return driver.findElement(xpath);
	}


	public WebElement clickBlueText() throws InterruptedException
	{
		driver.findElement(blueButton).click();
		Thread.sleep(1000);
		return driver.findElement(blueButton);
	}

	public String clickElementalSelenium() throws InterruptedException
	{
		driver.findElement(elementalSelenium).isDisplayed();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		driver.findElement(elementalSelenium).click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(500);
		// Perform the actions on new window
		driver.findElement(lblSauceLabs).getText();          
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println(CurrentUrl);

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		return CurrentUrl;
	}

	public String clickForkMeonGitHUb() throws InterruptedException
	{
		if(driver.findElement(forkMeOnGithub).isDisplayed()) {
			driver.findElement(forkMeOnGithub).click();
			Thread.sleep(1000);
		} else {
			System.out.println("First Wait");
			Thread.sleep(1000);
			if(driver.findElement(forkMeOnGithub).isDisplayed()) {
				driver.findElement(forkMeOnGithub).click();
			} else {
				System.out.println("Second Wait");
				Thread.sleep(1000);
			}
		}         
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		return CurrentUrl;
	}

	public String clickEdit() throws InterruptedException
	{
		driver.findElement(editButton).click();
		Thread.sleep(1000);
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		return CurrentUrl;

	}

	public String clickDelete() throws InterruptedException
	{
		driver.findElement(deleteButton).click();
		Thread.sleep(1000);
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println(CurrentUrl);
		return CurrentUrl;

	}

}
