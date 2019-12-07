package primusbanktests;
import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import primusbanklibrary.AdminHomePage;
import primusbanklibrary.BankerHomePage;
import primusbanklibrary.PrimusBankHomePage;
import utils.XLUtils;

public class PrimusBank_BatchTest extends Constants 
{
	@Test
	public void batchTest() throws IOException
	{
		PrimusBankHomePage phome=new PrimusBankHomePage();
		AdminHomePage ahome=new AdminHomePage();
		BankerHomePage bhome=new BankerHomePage();
				
		String keywordfile ="C:\\Users\\Satya\\eclipse-workspace\\PrimusBank-HybridFrameWork\\Keywords\\PrimusBankKeywords.xlsx";
		String tcsheet = "TestCases";
		String tssheet = "TestSteps";
		int tccount = XLUtils.getRowCount(keywordfile, tcsheet);
		int tscount = XLUtils.getRowCount(keywordfile, tssheet);
		
		String tsres,tcres;
		
		for (int i = 1; i <= tccount; i++)
		{
			String tcexeflag = XLUtils.getCellData(keywordfile, tcsheet, i, 2);
			if(tcexeflag.equalsIgnoreCase("y"))
			{
				String tcid = XLUtils.getCellData(keywordfile, tcsheet, i, 0);
				for (int j = 1; j <= tscount; j++)
				{
					String tstcid = XLUtils.getCellData(keywordfile, tssheet, j, 0);
					if(tstcid.equalsIgnoreCase(tcid))
					{
						boolean res = false;
						String keyword = XLUtils.getCellData(keywordfile, tssheet, j, 4);
						switch (keyword.toLowerCase()) {
						case "adminlogin":
							String uid = XLUtils.getCellData(keywordfile, tssheet, j, 5);
							String pwd = XLUtils.getCellData(keywordfile, tssheet, j, 6);
							res = phome.adminLogin(uid, pwd);
							break;
						case "adminlogout":
							res = ahome.adminLogout();
							break;
						case "bankerlogin":
							String bname = XLUtils.getCellData(keywordfile, tssheet, j, 5);
							uid = XLUtils.getCellData(keywordfile, tssheet, j, 6);
							pwd = XLUtils.getCellData(keywordfile, tssheet, j, 7);
							res = phome.bankerLogin(bname, uid, pwd);
							break;
						case "bankerlogout":
							res = bhome.bankerLogout();
							break;
						}
						if(res)
						{
							tsres="Pass";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XLUtils.fillGreenColor(keywordfile, tssheet, j, 3);
						}else 
						{
							tsres="Fail";
							XLUtils.setCellData(keywordfile, tssheet, j, 3, tsres);
							XLUtils.fillRedColor(keywordfile, tssheet, j, 3);
						}
						
						tcres=XLUtils.getCellData(keywordfile, tcsheet, i, 3);
						if(!tcres.equalsIgnoreCase("Fail"))
						{
							XLUtils.setCellData(keywordfile ,tcsheet , i, 3, tsres);
						}
						tcres=XLUtils.getCellData(keywordfile, tcsheet, i, 3);
						if(tcres.equalsIgnoreCase("Pass"))
						{
							XLUtils.fillGreenColor(keywordfile, tcsheet, i, 3);							
						}else
						{
							XLUtils.fillRedColor(keywordfile, tcsheet, i, 3);
						}
						
					}
					
				}
			}
		}
	}
}
	
	
	
	
	
	
	
	
	


		
