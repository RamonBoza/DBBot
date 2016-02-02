package org.boza.bots.dokkan.screens;

import com.oracle.tools.packager.Log;
import org.boza.bots.dokkan.driver.SikuliDriver;
import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public abstract class AbstractScreen {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractScreen.class);
	protected SikuliDriver driver;

	protected AbstractScreen()  {
		try {
			driver = new SikuliDriver();
		} catch (AWTException e) {
			LOGGER.error("Cannot initialize Sikuli, aborting");
		}
	}

	protected void executeAction(String action) {
		LOGGER.debug("Executing the action");
		driver.click(action);
		try {
			Thread.sleep(17000);
		} catch (InterruptedException e) {
			LOGGER.error("Found a problem when sleeping", e);
		}
	}

	protected boolean isDisplayed(String icon) {
		LOGGER.debug("Am I being displayed?");
		boolean isDisplayed = driver
				.isElementPresent(icon);
		LOGGER.debug("is being displayed " + isDisplayed);
		return isDisplayed;
	}

	protected void dragAndDrop(String iconFrom, String iconTo){
		LOGGER.debug("Executing the action");
		driver.dragAndDrop(iconFrom, iconTo);
		try {
			Thread.sleep(17000);
		} catch (InterruptedException e) {
			LOGGER.error("Found a problem when sleeping", e);
		}
	}
}
