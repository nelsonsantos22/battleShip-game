package org.academiadecodigo.battleship.boats;

import java.util.Random;

public class Boat  {

    private int[][] boats;

    public Boat(){
        this.boats = new int[5][2];

    }

    public void init(){

        Random random = new Random();

        for(int boat = 0 ; boat < 5 ; boat++){

            boats[boat][0]=random.nextInt(10);
            boats[boat][1]=random.nextInt(10);

            for(int last = 0 ; last < boat ; last++){

                if( (boats[boat][0] == boats[last][0]) && (boats[boat][1] == boats[last][1]) ) {

                    while ((boats[boat][0] == boats[last][0]) && (boats[boat][1] == boats[last][1])) {

                        boats[boat][0] = random.nextInt(10);
                        boats[boat][1] = random.nextInt(10);
                    }
                }
            }
        }
    }

    public int[][] getBoats() {
        return boats;
    }
}
