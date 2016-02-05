package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class TutorialScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(TutorialScreen.class);


    public Screen executeAction() {
        executeAction(DokkanResources.TUTORIAL_SCREEN);
        executeAction(DokkanResources.DOWNLOAD_COMPLETE_BUTTON);
        executeAction(DokkanResources.TUTORIAL_SCREEN);
        executeAction(DokkanResources.OK_DAILY_BUTTON);
        return new MainGameScreen();
    }

    public boolean isDisplayed() {
       return isDisplayed(DokkanResources.TUTORIAL_SCREEN);
    }
}
