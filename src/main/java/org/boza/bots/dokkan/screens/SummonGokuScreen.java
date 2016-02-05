package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class SummonGokuScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SummonGokuScreen.class);


    public Screen executeAction() {
        isDisplayed();
        dragAndDrop(DokkanResources.SUMMON_GOKU_PLANET, DokkanResources.SUMMON_GOKU_GROUND);
        return new SummonedCharacterScreen();
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.SUMMON_GOKU_SCREEN);
    }
}
