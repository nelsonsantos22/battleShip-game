package org.academiadecodigo.battleship.boats;

public class Submarine extends Boat {


    public Submarine(BoatOrientation boatOrientation, int posX, int posY) {
        super(boatOrientation, posX, posY);
        super.size = 3;
    }
}