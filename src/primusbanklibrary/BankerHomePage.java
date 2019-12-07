package primusbanklibrary;

import org.openqa.selenium.By;

import constants.Constants;

public class BankerHomePage extends Constants {
	
	public boolean bankerLogout()
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
		


