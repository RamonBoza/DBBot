package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ramon.boza on 1/2/16.
 */
public class HerculesScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory.getLogger(HerculesScreen.class);

    public Screen executeAction() {
        executeAction(DokkanResources.HERCULES_SCREEN);
        return new MainScreen();
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.HERCULES_SCREEN);
    }
}
