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
                System.out.println(MenuOptions.JOIN_GAME.getMessage());
                break;
            case "3":
                System.out.println(MenuOptions.CREDITS.getMessage());
                break;
            case "4":
                System.out.println(MenuOptions.HOW_TO_PLAY.getMessage());
                break;
            case "5":
                System.out.println(MenuOptions.QUIT.getMessage());
                break;
        }


    }

    public String getMenu() {
        return menu;
    }
}
