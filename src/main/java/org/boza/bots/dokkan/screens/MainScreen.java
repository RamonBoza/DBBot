package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class MainScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MainScreen.class);


    public Screen executeAction() {
        executeAction(DokkanResources.MAIN_SCREEN);
        return new TutorialScreen();
    }

    public boolean isDisplayed() {
       return isDisplayed(DokkanResources.MAIN_SCREEN);
    }
}
