package org.boza.bots.dokkan;

import org.boza.bots.dokkan.elements.CircularList;
import org.boza.bots.dokkan.exceptions.BotException;
import org.boza.bots.dokkan.screens.*;

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
        screens.add(new EmulatorScreen());
		screens.add(new HerculesScreen());
		screens.add(new MainScreen());
        screens.add(new ExitEmulatorScreen());
	}

	public void addScreen(final Screen screen) {
		screens.add(screen);
	}

	public void locateItself() {
		boolean found;
		do {
			Screen screen = screens.next();
			found = screen.isDisplayed();
		} while (!found);
	}

	public void runBot() throws BotException {
		while (true) {
			Screen screen = screens.get();
            if(!screen.isDisplayed())
                throw new BotException();
			screen.executeAction();
			screens.next();
		}
	}
}
