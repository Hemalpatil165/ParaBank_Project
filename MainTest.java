package mvn;
import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi.sm3WithSM2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.browse.BrowserConfigration;
import com.google.common.io.Files;

///import Browser.BrowserConfigration;
//import Model.Login;
//import Model.Registration;
//import Model.Sidemenu;

@Test
public class MainTest {
	WebDriver driver=null;
	Model.Registration lp=null; 
	Model.Login rp=null;
	Model.Sidemenu Sm=null;


	@BeforeClass
	public void Browser() throws InterruptedException
	{
		driver=new BrowserConfigration().ChromeBrowserSelection("edge", "https://parabank.parasoft.com/parabank/register.htm");
		Thread.sleep(3000);
	}
	@BeforeTest
	public void beforetest()
	{
		lp=new Model.Registration();
		rp=new Model.Login();
		Sm=new Model.Sidemenu();
		
	}
	@Test(priority = 0)
	public void Registation() throws InterruptedException
	{
		lp.enterfirstname(driver, "Hemal");
		lp.enterlastname(driver, "Patil");
		lp.enterAddress(driver, "Bhestan,Surat");
		lp.entercity(driver, "Surat");
		lp.enterstate(driver, "Gujrat");
		lp.enterzipcode(driver, "395023");
		lp.enterphonenumber(driver, "9192939495");
		lp.enterssn(driver, "Indian");
		lp.enterusername(driver, "hemal_06");
		lp.enterpassword(driver, "hemal0606");
		lp.enterrepeatedpassword(driver, "hemal0606");
		lp.clickregister(driver);
		
		System.out.println("your Registation has been Done...");
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {
		
		rp.eneterloginname(driver, "hemal_06");
		rp.eneterloginpassword(driver, "hemal0606");
		rp.clicklogin(driver);
		
	}
	@Test(priority = 2)
	public void Sidemenu() throws InterruptedException {
		
		Sm.Service(driver);
		driver.navigate().back();
		Sm.Products(driver);
		driver.navigate().back();
		Sm.Location(driver);
		driver.navigate().back();
		Sm.Adminpage(driver);
		driver.navigate().back();
		
	}
	
	@Test(priority = 3)
	public void ss() throws IOException, InterruptedException {
		
	
	File file=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
	
	Files.copy(file,new File("D:\\Selenium\\SS\\defect5.png"));
	
	Thread.sleep(2000);
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("Bye Bye...");
		Thread.sleep(3000);
		driver.close();	
		
			
	}
}

