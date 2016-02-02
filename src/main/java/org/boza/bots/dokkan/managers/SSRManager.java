package org.boza.bots.dokkan.managers;

import org.boza.bots.dokkan.screens.CreateTransferCodeScreen;
import org.boza.bots.dokkan.screens.FinishSummonedCharacterScreen;
import org.boza.bots.dokkan.screens.GoToMenuScreen;
import org.boza.bots.dokkan.screens.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon.boza on 2/2/16.
 */
public class SSRManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(SSRManager.class);
    private static SSRManager instance = null;

    private int ssrCounter = 0;

    private List<Screen> screens;

    private SSRManager() {
        screens = new ArrayList<Screen>();
        screens.add(new FinishSummonedCharacterScreen());
        screens.add(new GoToMenuScreen());
        screens.add(new CreateTransferCodeScreen());
    }

    public static SSRManager getInstance () {
        if(instance == null){
            instance = new SSRManager();
        }
        return instance;
    }


    public void gotNewSSR() {
        ssrCounter++;
        getScreenShotForSSRCharacter();
        createTransferCode();
        getScreenShotforTransferCode();
    }

    private void createTransferCode() {
        for( Screen screen : screens){
            screen.executeAction();
        }
    }

    private void getScreenShotForSSRCharacter() {

        BufferedImage image = null;
        String ssrScreenShot = getSSRScreenshotName();
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File(ssrScreenShot));
        } catch (AWTException e) {
            LOGGER.error("Problem capturing image",e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Problem saving image to file", e.getMessage());
        } finally {
            image = null;
        }
    }

    private void getScreenShotforTransferCode() {
        BufferedImage image = null;
        String ssrScreenShot = getTransfercodeScreenshotName();
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File(ssrScreenShot));
        } catch (AWTException e) {
            LOGGER.error("Problem capturing image",e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Problem saving image to file", e.getMessage());
        } finally {
            image = null;
        }
    }

    private String getTransfercodeScreenshotName() {
        return ssrCounter+"_transfer_code";
    }

    private String getSSRScreenshotName() {
        return ssrCounter + "_ssr_character";
    }
}
