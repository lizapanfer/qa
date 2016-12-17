package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest {

	private Random rand = new Random();
	private int num = rand.nextInt(10);
	private Steps steps;
	private final String EMAIL = "testtesttesttest4test@gmail.com";
	private final String PASSWORD = "123456qwe";
	private final String USERNAME = "Test4Test";
	private final String URL = "TTTEEESSSTTT" + num;
	private final String FINDUPHEADER = "Смотрите, какими идеями делятся ваши друзья";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Go to the Find Friend Page")
	public void oneCanGoToFFPage()
	{
		steps.loginPin(EMAIL,PASSWORD);
		String s = steps.goToFindFriendPage();
		Assert.assertTrue(steps.isInFFPage(s,FINDUPHEADER));
		steps.logoutPin();
	}

	@Test(description = "Login to Pinterest")
	public void oneCanLoginPin()
	{
		steps.loginPin(EMAIL,PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
		steps.logoutPin();
	}

	@Test(description = "Change Profile URL")
	public void oneCanChangeURL()
	{
		steps.loginPin(EMAIL,PASSWORD);
		steps.goToSettingsPage();
		steps.changeUrl(URL);
		Assert.assertTrue(steps.isUrlChanged(URL));
		steps.logoutPin();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
