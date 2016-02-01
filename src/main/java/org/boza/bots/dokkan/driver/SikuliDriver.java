package org.boza.bots.dokkan.driver;

import java.net.URL;
import java.util.List;

import org.sikuli.api.DefaultScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.Screen;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.api.robot.desktop.DesktopScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SikuliDriver {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(SikuliDriver.class);

	private static final double TARGET_SCORE = 0.5;
	private static final String IMAGES = "/images/";
	private Screen screen;
	ScreenRegion region;
	Mouse mouse;

	public SikuliDriver() {
		screen = new DesktopScreen(0);
		region = new DefaultScreenRegion(screen);
		mouse = new DesktopMouse();
	}

	public boolean isElementPresent(String elementIdentification) {
		Target target = new ImageTarget(
				getURLFromElement(elementIdentification));
		target.setMinScore(TARGET_SCORE);
		List<ScreenRegion> find = region.findAll(target);
		LOGGER.debug("Found " + find.size() + " elements with score > "
				+ TARGET_SCORE);
		for (ScreenRegion screenRegion : find) {
			LOGGER.debug("\tElement with score: " + screenRegion.getScore()
					+ "and bounds " + screenRegion.getBounds().getCenterX()
					+ "," + screenRegion.getBounds().getCenterY());
		}
		return find.size() > 0;
	}

	public void click(String elementIdentification) {
		Target target = new ImageTarget(
				getURLFromElement(elementIdentification));
		target.setMinScore(TARGET_SCORE);
		ScreenRegion find = region.find(target);

		mouse.click(find.getCenter());

	}

	private URL getURLFromElement(String elementIdentification) {
		URL resource = getClass().getResource(IMAGES + elementIdentification);
		return resource;
	}
}
