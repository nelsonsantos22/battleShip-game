package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.server.PlayerHandler;
import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.IOException;
import java.io.PrintStream;

public class Credits {

    public void printCredits(PlayerHandler playerHandler) {

        try {

            PrintStream out = new PrintStream(playerHandler.getPlayerSocket().getOutputStream(), true);
            Prompt prompt = new Prompt(playerHandler.getPlayerSocket().getInputStream(), out);

            StringInputScanner stringInputScanner = new StringInputScanner();

            out.print("\u001B[2J");


            out.print("\u001B[36m");
            out.print(Messages.LOGO);
            out.print("\u001B[37m");
            out.print(Messages.CREDITS);
            out.flush();

            prompt.getUserInput(stringInputScanner);


        } catch (IOException e) {

            e.printStackTrace();

        }
    }


}
