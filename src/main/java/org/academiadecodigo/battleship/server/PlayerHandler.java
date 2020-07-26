package org.academiadecodigo.battleship.server;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.battleship.Player;
import org.academiadecodigo.battleship.menu.Menu;
import org.academiadecodigo.battleship.util.Messages;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class PlayerHandler implements Runnable{

    private Socket playerSocket;
    private PrintWriter out;
    private LinkedList<PlayerHandler> list;
    private String messageIn;
    private String messageOut;
    private Menu menu;
    private Game game;
    private Player player;

    public PlayerHandler(Socket playerSocket){
        this.playerSocket = playerSocket;
        //this.game = game;
        this.player = new Player();
    }


  public void handleClient(Socket clientSocket){
        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            menu = new Menu(this, game);


            while (true) {
                if(messageOut == "Start Game" || messageOut == "Join Game") {
                    messageOut = "";
                    out.write(Messages.PLAYERS_CONNECTED);
                    out.flush();
                } else {
                    out.write(menu.getMenu());
                    out.flush();
                    messageIn = in.readLine();
                }


                if (messageIn == null || messageIn.equals("/quit")) {
                    in.close();
                    clientSocket.close();
                    break;
                }

                //     game.setAction(getMessageIn());
                menu.onMenuSelection(messageIn);

                if(messageOut == "Quit"){
                    break;
                } else {
                    out.write(messageOut);
                    out.flush();
                }

            }
        } catch (IOException e){

            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        handleClient(playerSocket);
    }

    public String getMessageIn() {
        return messageIn;
    }

    public void setMessageOut(String message) {
        messageOut = message;
    }
}
