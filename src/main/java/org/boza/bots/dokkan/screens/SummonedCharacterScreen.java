package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.managers.SSRManager;
import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class SummonedCharacterScreen extends AbstractScreen implements Screen {

    private SSRManager ssrManager;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(SummonedCharacterScreen.class);

    public SummonedCharacterScreen(){
        ssrManager = new SSRManager();
    }

    public Screen executeAction() {
        if(isDisplayed(DokkanResources.SSR_SUMMONED_CHARACTER_SUCCESS))
            ssrManager.gotNewSSR();
    }

    public boolean isDisplayed() {
        return isDisplayed(DokkanResources.SUMMONED_CHARACTER_SCREEN);
    }
}
