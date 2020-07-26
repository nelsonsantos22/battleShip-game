package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.boats.Boat;
import org.academiadecodigo.battleship.gameplay.Cheat;
import org.academiadecodigo.battleship.gameplay.PlayerTurn;
import org.academiadecodigo.battleship.menu.FinalScreen;
import org.academiadecodigo.battleship.server.PlayerHandler;


public class Game {


    PlayerTurn playerTurn;
    Field field;
    Boat boat;
    Cheat cheat;

    int attempts=0, shotHit=0;

    public Game() {
    }

    public void start(PlayerHandler playerHandler) {

        field = new Field();
        boat = new Boat();
        playerTurn = new PlayerTurn();
        cheat = new Cheat();

        field.init();
        boat.init();



        System.out.println();

        while (shotHit != 5){

            field.showField(field.getField(), playerHandler);
            playerTurn.shoot(playerTurn.getShoot(), playerHandler);
            attempts++;

            if(playerTurn.hit(playerTurn.getShoot(), boat.getBoats(), playerHandler)){
                cheat.hint(playerTurn.getShoot(), boat.getBoats(), this);
                shotHit++;

            } else {

                cheat.hint(playerTurn.getShoot(), boat.getBoats(), this);

            }

            field.fieldUpdate(playerTurn.getShoot(), boat.getBoats(), field.getField(), playerTurn, playerHandler);

        }

        FinalScreen.printFinalScreen(playerHandler,attempts);


    }

    public int getAttempts() {
        return attempts;
    }
}
