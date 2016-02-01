package org.boza.bots.dokkan;

import org.boza.bots.dokkan.elements.CircularList;
import org.boza.bots.dokkan.screens.HerculesScreen;
import org.boza.bots.dokkan.screens.MainScreen;
import org.boza.bots.dokkan.screens.Screen;

/**
 * Hello world!
 * 
 */
public class DokkanBot {
	CircularList<Screen> screens;

	public DokkanBot() {
		screens = new CircularList<Screen>();
	}

	public void defaultSetup() {
		screens.add(new HerculesScreen());
		screens.add(new MainScreen());
	}

	public void addScreen(final Screen screen) {
		screens.add(screen);
	}

	public void locateItself() {
		boolean found = false;
		do {
			Screen screen = screens.next();
			found = screen.isDisplayed();
		} while (!found);
	}

	public void runBot() {
		while (true) {
			Screen screen = screens.get();
			screen.executeAction();
			screens.next();
		}
	}
}
