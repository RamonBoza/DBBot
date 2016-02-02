package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class SummonScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SummonScreen.class);


    public void executeAction() {
        executeAction(DokkanResources.SUMMON_BUTTON);
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.SUMMON_BUTTON);
    }
}
