package org.academiadecodigo.battleship.server;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.battleship.menu.Menu;
import org.academiadecodigo.battleship.util.Messages;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class PlayerHandler implements Runnable{

    private Socket playerSocket;
    private PrintWriter out;
    private LinkedList<PlayerHandler> list;
    private String messageIn;
    private Game game;
    private Menu menu = new Menu();


    public PlayerHandler(Socket playerSocket, LinkedList list, Game game){
        this.playerSocket = playerSocket;
        this.list = list;
        this.game = game;
    }


    public void handleClient(Socket clientSocket){

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.write(menu.getWelcomeMessage());
            out.flush();

            while (true) {

                messageIn = in.readLine();

                if (messageIn == null || messageIn.equals("/quit")) {
                    in.close();
                    clientSocket.close();
                    break;
                }

                game.setAction(getMessageIn());

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
