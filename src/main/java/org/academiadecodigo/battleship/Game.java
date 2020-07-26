package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.util.Messages;

public class Game {
    Field field1, field2;
    Player player1, player2;

    private String action;
    private int counter = 0;
    private int countGame = 0;

    public Game() {
        countGame++;
    }

    private void init() {
        //inicializa coisinhas
    }

    public void start() {
        counter++;
        if(counter==2){
            System.out.println("game has started..."+counter);

        }
        System.out.println(counter);
        //start do game();
        //listenTheInput();
        //checkseéaguaoubarcosebarcokoisenãobarconadaeatualizaGrid();

    }

    private void boatPlacement(int position1, int position2, int player, String boat) {
        //recebe input do player e guarda num array as posiçoes

        if(position1 > 50 || position2 > 50) {
            System.out.println(Messages.ERROR_PLACE_BOATS);
            return;
        }

        if(player == 1) {
            field1.setBoat(position1, position2,boat);
            return;
        }

        if(player == 2) {
            field2.setBoat(position1,position2,boat);
            return;
        }
    }


    private void checkPosition(int position1, int position2, int player) {

        if(position1 > 50 || position2 > 50) {
            System.out.println(Messages.ERROR_PLACE_BOATS);
            return;
        }

        if(player == 1) {
            field2.shoot(position1, position2);
            return;
        }

        if(player == 2) {
            field1.shoot(position1, position2);
            return;
        }

    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
