package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.battleship.server.PlayerHandler;
import org.academiadecodigo.battleship.util.Colors;
import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;


public class Menu {

    private String menu;
    private PlayerHandler playerHandler;
    private Game game = new Game();


    public Menu(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
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
                game.start(playerHandler);
                break;
            case "2":
                new HowToPlay().printHTP(playerHandler);
                showMenu();
                break;
            case "3":
                new Credits().printCredits(playerHandler);
                showMenu();
                break;
            case "4":
                playerHandler.close();
                break;

        }
    }


    public String getMenu() {
        return menu;
    }
}
