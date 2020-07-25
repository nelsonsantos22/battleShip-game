package org.academiadecodigo.battleship.server;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.battleship.menu.Menu;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class PlayerHandler implements Runnable{

    private Socket playerSocket;
    private PrintWriter out;
    private LinkedList<PlayerHandler> list;
    private String messageIn;
    private Game game;
    private Menu menu;


    public PlayerHandler(Socket playerSocket, LinkedList list, Game game){
        this.playerSocket = playerSocket;
        this.list = list;
        this.game = game;
    }


    public void handleClient(Socket clientSocket){

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            menu = new Menu(this);


            while (true) {
                out.write(menu.getMenu());
                out.flush();
                messageIn = in.readLine();

                if (messageIn == null || messageIn.equals("/quit")) {
                    in.close();
                    clientSocket.close();
                    break;
                }

                game.setAction(getMessageIn());
                menu.onMenuSelection(messageIn);

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
}
