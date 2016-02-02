package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.managers.SSRManager;
import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class FinishSummonedCharacterScreen extends AbstractScreen implements Screen {


    private static final Logger LOGGER = LoggerFactory
            .getLogger(FinishSummonedCharacterScreen.class);


    public void executeAction() {
        executeAction(DokkanResources.SSR_SUMMONED_CHARACTER_SUCCESS);
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.SUMMONED_CHARACTER_SCREEN);
    }
}
