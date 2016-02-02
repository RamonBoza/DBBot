package org.boza.bots.dokkan.main;

import org.boza.bots.dokkan.DokkanBot;
import org.boza.bots.dokkan.exceptions.BotException;

/**
 * Created by ramon.boza on 1/2/16.
 */
public class BotExecutor {

    public static void main(String[] args) throws Exception {

        DokkanBot bot = new DokkanBot();
        bot.defaultSetup();
        bot.locateItself();
        while (true) {
            try {
                bot.runBot();
            } catch (BotException e) {
                bot.locateItself();
            }
        }
    }
}
