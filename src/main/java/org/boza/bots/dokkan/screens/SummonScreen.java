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
    private final boolean firstTime;

    public SummonScreen(boolean firstTime){
        this.firstTime = firstTime;
    }


    public Screen executeAction() {
        if(firstTime) {
            isDisplayed(DokkanResources.MULTI_SUMMON_BUTTON);
            executeAction(DokkanResources.GO_DOWN_SUMMON_BUTTON);
        }
        executeAction(DokkanResources.SINGLE_SUMMON_BUTTON);
        executeAction(DokkanResources.CLICK_SUMMON_BUTTON);
        if(isDisplayed(DokkanResources.NO_MORE_STONES_MESSAGE))
            return new ExitEmulatorScreen();
        return new SummonGokuScreen();
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.SUMMON_BUTTON);
    }
}
