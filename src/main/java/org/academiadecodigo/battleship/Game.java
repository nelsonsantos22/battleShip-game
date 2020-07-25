package org.academiadecodigo.battleship;

import org.academiadecodigo.battleship.battlefield.Battlefield;

public class Game {

    private Battlefield battlefield;
    private String action;

    public Game() {
        this.battlefield = new Battlefield();
    }

    private void init() {
        //inicializa coisinhas
    }

    private void start() {
        //start do game();
        //boatPalcement();
        //checkPosition();
        //listenTheInput();
        //checkseéaguaoubarcosebarcokoisenãobarconadaeatualizaGrid();

    }

    private void boatPlacement() {
        //recebe input do player e guarda num array as posiçoes
    }


    private void checkPosition() {
        // verificar se posição é válida
        // verificar limites da grid

    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
