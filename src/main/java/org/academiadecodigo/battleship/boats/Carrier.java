package org.academiadecodigo.battleship.boats;

public class Carrier extends Boat {


    public Carrier(BoatOrientation boatOrientation, int posX, int posY) {
        super(boatOrientation, posX, posY);
        super.size = 5;
    }
}
