package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class MainGameScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MainGameScreen.class);


    public Screen executeAction() {
        executeAction(DokkanResources.MAIN_GAME_SCREEN);
        executeAction(DokkanResources.ACCEPT_ALL_BUTTON);
        executeAction(DokkanResources.ACCEPT_ALL_OK_BUTTON);
        executeAction(DokkanResources.ACCEPT_ALL_OK_BUTTON);
        executeAction(DokkanResources.ACCEPT_ALL_BUTTON);
        executeAction(DokkanResources.ACCEPT_ALL_OK_BUTTON);
        executeAction(DokkanResources.ACCEPT_ALL_OK_BUTTON);
        executeAction(DokkanResources.SUMMON_BUTTON);
        return new SummonScreen(true);
    }

    public boolean isDisplayed() {
       return isDisplayed(DokkanResources.MAIN_GAME_SCREEN);
    }
}
