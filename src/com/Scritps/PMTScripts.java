package com.Scritps;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Common.Common;
import Common.Initial;
import Actions.logActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PMTScripts {
	Common common;
	logActions actions;
	Initial init;
	WebDriver driver;

	public PMTScripts() {
		// TODO Auto-generated constructor stub
		init = new Initial();
		driver = init.getDriver();
		common = new Common(driver);
		actions = new logActions(driver);
	}

	@BeforeClass
	public void BeforeClass() {
		try {
			common.OpenURL();
			common.closeChromeExtension();	
			String userFlag = "1"; // flag to look for into the .xls file
			Object[] modHeader = common.readModHeaderFile(userFlag, "Parameters");//login info is get from xls file
			actions.login(modHeader);
			common.closeSavePasswordPopUp();
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@AfterClass
	public void AfterClass() {
		//uncomment this to allow the browser to be close after test
		//common.closeBrowser();
	}

	@Test
	public void testGoogleSearch() {

		String p = "wewe";
	}

}
