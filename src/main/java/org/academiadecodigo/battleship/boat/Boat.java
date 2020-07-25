package org.academiadecodigo.battleship.boat;

import java.util.ArrayList;

public class Boat {

    private BoatType boatType;
    private int posX, posY;
    private ArrayList<Position> positionsArrayList = new ArrayList<>();


    public Boat(BoatType boatType, int posX, int posY) {
        this.boatType = boatType;
        this.posY = posX;
        this.posY = posY;

        Position position = new Position(this.posX, this.posY);
        positionsArrayList.add(position);
    }


    private int getPosX() {
        return this.posX;
    }

    private int getPosY() {
        return this.posY - 1;
    }
}
