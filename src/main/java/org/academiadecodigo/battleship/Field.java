package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.util.Messages;

public class Field {
    private String[][] field = new String[50][50];


    public void setBoat(int position1, int position2, String boat) {
        field[position1][position2] = boat;
    }

    public void shoot(int position1, int position2){
        if(field[position1][position2] == "~") {

            field[position1][position2] = "o";
            System.out.println(Messages.HIT_WATER_SHOOT);
            return;

        }

        if(field[position1][position2] != "~") {

            field[position1][position2] = "x";
            System.out.println(Messages.HIT_BOAT_SHOOT);
            return;

        }

        if(field[position1][position2] == "o") {

            System.out.println(Messages.HIT_WATER_SHOOT);
            return;

        }

    }
}
