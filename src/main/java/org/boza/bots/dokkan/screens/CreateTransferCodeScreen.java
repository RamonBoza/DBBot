package org.boza.bots.dokkan.screens;

import org.boza.bots.dokkan.resources.DokkanResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;


/**
 * Created by ramon.boza on 1/2/16.
 */
public class CreateTransferCodeScreen extends AbstractScreen implements Screen {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(CreateTransferCodeScreen.class);

    public Screen executeAction() {
        executeAction(DokkanResources.TRANSFER_CODE_BUTTON);
        executeAction(DokkanResources.TRANSFER_CODE_OK_BUTTON);
    }

    public boolean isDisplayed() {
       return isDisplayed(DokkanResources.TRANSFER_CODE_BUTTON);
    }
}
