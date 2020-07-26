package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.battleship.server.PlayerHandler;
import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;


public class Menu {

    private String menu;
    private PlayerHandler playerHandler;
    private Game game;

    public Menu(PlayerHandler playerHandler, Game game) {
        this.playerHandler = playerHandler;
        this.game = game;
        init();
    }

    public void init(){
        showMenu();
    }

    public void showMenu() {

        MenuInputScanner scanner = new MenuInputScanner(MenuOptions.getMessages());
        scanner.setMessage("\n" + Messages.LOGO);
        menu = scanner.getMessage();

    }

    public void onMenuSelection(String option) {

        switch (option) {
            case "1":
                System.out.println(MenuOptions.START_GAME.getMessage());
                game.start();
                break;
            case "2":
                playerHandler.setMessageOut(MenuOptions.JOIN_GAME.getMessage());
                break;
            case "3":
                playerHandler.setMessageOut("Game created by Neco, Joana, Ricardo e Rafa");
                break;
            case "4":
                playerHandler.setMessageOut("HOW TO PLAY \n to place and atack write the coordinates like this example '1:5' and this will atack the position 1 5");
                break;
            case "5":
                playerHandler.setMessageOut(MenuOptions.QUIT.getMessage());
                break;
        }


    }

    public String getMenu() {
        return menu;
    }
}
