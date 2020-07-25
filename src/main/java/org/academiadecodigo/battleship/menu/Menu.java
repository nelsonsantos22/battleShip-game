package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public Menu() {
        showMenu();
    }

    private void showMenu() {

        Prompt prompt = new Prompt(System.in,System.out);

        MenuInputScanner scanner = new MenuInputScanner(MenuOptions.getMessages());
        scanner.setMessage("\n" + Messages.LOGO);

        onMenuSelection(prompt.getUserInput(scanner));

    }

    private void onMenuSelection(int option) {
        
        switch (option) {
            case 1:
                System.out.println(MenuOptions.START_GAME.getMessage());
            case 2:
                System.out.println(MenuOptions.JOIN_GAME.getMessage());
            case 3:
                System.out.println(MenuOptions.CREDITS.getMessage());
            case 4:
                System.out.println(MenuOptions.HOW_TO_PLAY.getMessage());
            case 5:
                System.out.println(MenuOptions.QUIT.getMessage());
        }


    }
}
