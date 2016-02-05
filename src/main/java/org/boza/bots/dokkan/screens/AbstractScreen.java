package org.boza.bots.dokkan.screens;

import com.oracle.tools.packager.Log;
import org.boza.bots.dokkan.driver.SikuliDriver;
import org.boza.bots.dokkan.exceptions.BotException;
import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.concurrent.*;

public abstract class AbstractScreen {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractScreen.class);
    protected SikuliDriver driver;

    protected AbstractScreen() {
        try {
            driver = new SikuliDriver();
        } catch (AWTException e) {
            LOGGER.error("Cannot initialize Sikuli, aborting");
        }
    }

    protected void executeAction(String action) {
        LOGGER.debug("Executing the action");
        try {
            waitForElementToBePresent(action);
            driver.click(action);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Found a problem when sleeping", e);
        } catch (BotException e) {
            LOGGER.error("Found a problem when sleeping", e);
        }
    }

    protected boolean isDisplayed(String icon) {
        LOGGER.debug("Am I being displayed?" + icon);
        boolean isDisplayed = driver
                .isElementPresent(icon);
        LOGGER.debug("is being displayed " + icon + " " + isDisplayed);
        return isDisplayed;
    }

    protected void dragAndDrop(String iconFrom, String iconTo) {
        LOGGER.debug("Executing the action");
        driver.dragAndDrop(iconFrom, iconTo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Found a problem when sleeping", e);
        }
    }

    private void waitForElementToBePresent(final String action) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        final Future handler = executor.submit(new Callable() {
            public Object call() throws Exception {
                boolean found;
                do
                {
                    found = isDisplayed(action);
                }
                while(!found);
                return null;
            }
        });

        executor.schedule(new Runnable() {
            public void run() {
                handler.cancel(true);
            }
        }, 10000, TimeUnit.MILLISECONDS);


    }
}
