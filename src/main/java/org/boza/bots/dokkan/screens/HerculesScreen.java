package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ramon.boza on 1/2/16.
 */
public class HerculesScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory.getLogger(HerculesScreen.class);

    public void executeAction() {
        LOGGER.debug("Executing the action");
        driver.click(DokkanResources.HERCULES_SCREEN);
        try {
            Thread.sleep(17000);
        } catch (InterruptedException e) {
            LOGGER.error("Found a problem when sleeping", e);
        }
    }

    public boolean isDisplayed() {
        LOGGER.debug("Am I being displayed?");
        boolean isDisplayed = driver
                .isElementPresent(DokkanResources.HERCULES_SCREEN);
        LOGGER.debug("is being displayed " + isDisplayed);
        return isDisplayed;
    }
}
