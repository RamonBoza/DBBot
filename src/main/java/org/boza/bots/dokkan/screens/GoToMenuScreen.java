package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class GoToMenuScreen extends AbstractScreen implements Screen {


    private static final Logger LOGGER = LoggerFactory
            .getLogger(GoToMenuScreen.class);


    public Screen executeAction() {
        executeAction(DokkanResources.MENU_BUTTON_SCREEN);
        return null;
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.MENU_BUTTON_SCREEN);
    }
}
