package org.academiadecodigo.battleship.boats;

import java.util.ArrayList;

public class Boat {

    //private BoatType boatType;
    private int posX, posY;
    protected int size;
    private BoatOrientation boatOrientation;
    private ArrayList<Position> positionsArrayList = new ArrayList<>();


    public Boat(BoatOrientation boatOrientation, int posX, int posY) {
        //this.boatType = boatType;
        this.boatOrientation = boatOrientation;
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
