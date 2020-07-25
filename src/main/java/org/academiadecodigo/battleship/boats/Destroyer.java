package org.academiadecodigo.battleship.boats;

public class Destroyer extends Boat {


    public Destroyer(BoatOrientation boatOrientation, int posX, int posY) {
        super(boatOrientation, posX, posY);
        super.size = 3;
    }
}
