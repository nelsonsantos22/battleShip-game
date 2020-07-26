package org.academiadecodigo.battleship.gameplay;

import org.academiadecodigo.battleship.Game;

public class Cheat {


    public Cheat(){

    }

    public void hint(int[] shoot, int[][] ships, Game game){

        int row = 0, column = 0;

        for(int line = 0 ; line < ships.length ; line++){

            if(ships[line][0] == shoot[0]) {
                row++;
            }

            if(ships[line][1] == shoot[1]) {
                column++;
            }
        }

        System.out.printf("\nHint " + game.getAttempts() + ":" + "\nRow " + (shoot[0] + 1) + " -> " + row + " ships\n" +
                "Column " + (shoot[1] +1) + " -> " + column + " ships\n");
    }



}
