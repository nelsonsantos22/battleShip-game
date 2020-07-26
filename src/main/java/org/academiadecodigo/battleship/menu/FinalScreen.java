package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.server.PlayerHandler;
import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.IOException;
import java.io.PrintStream;

public class FinalScreen {
    public static void printFinalScreen(PlayerHandler playerHandler, int attempts) {
     try {

        PrintStream out = new PrintStream(playerHandler.getPlayerSocket().getOutputStream(), true);
         out.print("\u001B[2J");
         out.print(Messages.LOGO);
         out.print("\n\n\n                 " + Messages.WIN + attempts + " attempts!");

    } catch (
    IOException e) {

        e.printStackTrace();

    }
}
}
