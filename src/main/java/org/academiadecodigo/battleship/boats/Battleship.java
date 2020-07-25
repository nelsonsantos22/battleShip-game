package org.academiadecodigo.battleship.boats;

public class Battleship extends Boat {


    public Battleship(BoatOrientation boatOrientation, int posX, int posY) {
        super(boatOrientation, posX, posY);
        super.size = 4;
    }

}
