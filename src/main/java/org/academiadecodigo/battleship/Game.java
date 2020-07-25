package org.academiadecodigo.battleship;

public class Game {
    Field field1, field2;
    Player player1, player2;

    private String action;
    private int counter = 0;

    public Game() {
    }

    private void init() {
        //inicializa coisinhas
    }

    public void start() {
        counter++;
        if(counter==2){
            System.out.println("game has started..."+counter);

        }
        System.out.println(counter);
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
