package org.academiadecodigo.battleship.boat;

public enum BoatType {
    DESTROYER(3),
    SUBMARINE(3),
    BATTLESHIP(4),
    PATROL_BOAT(2),
    CARRIER(5);

    private int boatSize;

    BoatType(int boatSize) {
        this.boatSize = boatSize;
    }
}
