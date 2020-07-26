package org.academiadecodigo.battleship.gameplay;

import org.academiadecodigo.battleship.server.PlayerHandler;

import java.io.IOException;

public class PlayerTurn {

    private int[] shoot;

    public PlayerTurn(){

        shoot = new int[2];
    }

    public void shoot(int[] shoot, PlayerHandler playerHandler){

        try {

            playerHandler.getOut().write("Row:  ");
            playerHandler.getOut().flush();
            shoot[0] = Integer.parseInt(playerHandler.getIn().readLine());
            shoot[0]--;

            playerHandler.getOut().write("Column:  ");
            playerHandler.getOut().flush();
            shoot[1] = Integer.parseInt(playerHandler.getIn().readLine());
            shoot[1]--;

        } catch (IOException e){

            e.printStackTrace();

        }
    }

    public boolean hit(int[] shoot, int[][] ships){

        for(int ship = 0 ; ship < ships.length ; ship++){

            if( shoot[0] == ships[ship][0] && shoot[1] == ships[ship][1]){

                System.out.printf(/*Messages.HIT_BOAT +*/ " (%d,%d)\n", shoot[0] + 1, shoot[1] + 1);
                return true;

            }
        }
        return false;
    }



    public int[] getShoot() {
        return shoot;
    }
}
