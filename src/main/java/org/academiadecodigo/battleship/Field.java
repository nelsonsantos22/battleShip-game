package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.gameplay.PlayerTurn;
import org.academiadecodigo.battleship.server.PlayerHandler;

public class Field {

    private int[][] field;

    public Field(){
       field = new int[10][10];

    }


    public void init(){

        for(int row=0 ; row < 10 ; row++ ) {
            for (int column = 0; column < 10; column++) {
                field[row][column] = -1;
            }
        }
    }

    public void showField(int[][] board, PlayerHandler playerHandler){

        playerHandler.getOut().print("\u001B[2J");


        playerHandler.getOut().write("\n");
        playerHandler.getOut().write("\n");
        playerHandler.getOut().write("\n");
        playerHandler.getOut().write("\n");

        playerHandler.getOut().write("                                           COLUMN\n\n");
        playerHandler.getOut().write("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \n");
        playerHandler.getOut().write("");


        for(int row = 0 ; row < 10 ; row++ ){

            playerHandler.getOut().write((row + 1) + "");
            playerHandler.getOut().flush();

            for(int column = 0 ; column < 10 ; column++ ){

                if(board[row][column] == -1){

                    playerHandler.getOut().write("\t" + "\u001B[36m~\u001B[37m");
                    playerHandler.getOut().flush();

                } else if(board[row][column] == 0){

                    playerHandler.getOut().write("\t" + "O");
                    playerHandler.getOut().flush();

                } else if(board[row][column] == 1){

                    playerHandler.getOut().write("\t" + "\u001B[31mX\u001B[37m");
                    playerHandler.getOut().flush();

                }
            }

            playerHandler.getOut().write("\n");
            playerHandler.getOut().flush();
        }
    }

    public void fieldUpdate(int[] shoot, int[][] ships, int[][] board, PlayerTurn playerTurn, PlayerHandler playerHandler){

        if(playerTurn.hit(shoot,ships, playerHandler)) {

            board[shoot[0]][shoot[1]] = 1;

        } else {

            board[shoot[0]][shoot[1]] = 0;

        }
    }

    public int[][] getField() {
        return field;
    }

}
