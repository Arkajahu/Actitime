package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;
@Listeners(ListenerImplementation.class)
public class CreateCustomner extends BaseClass {
	
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.getTasktab().click();
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewcust().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
		String name = f.readDataFromExcel("Sheet1", 1, 1);
		tp.getCustname().sendKeys(name);
		String desp = f.readDataFromExcel("Sheet1", 1, 2);
		tp.getCustdesp().sendKeys(desp);
		tp.getCreatecust().click();
		
		String expectedresult = name;
		String actualresult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(expectedresult, actualresult);
		s.assertAll();
		
	}

}
