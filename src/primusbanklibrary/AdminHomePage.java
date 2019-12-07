package primusbanklibrary;

import org.openqa.selenium.By;

import constants.Constants;

public class AdminHomePage extends Constants {
	public boolean adminLogout()
	{
		driver.findElement
		       (By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
		
		if(driver.findElement(By.id("login")).isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	

}
