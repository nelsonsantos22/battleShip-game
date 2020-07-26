package org.academiadecodigo.battleship.server;

import org.academiadecodigo.battleship.menu.Menu;
import org.academiadecodigo.battleship.util.Messages;

import java.io.*;
import java.net.Socket;

public class PlayerHandler implements Runnable{

    private Socket playerSocket;
    private PrintWriter out;
    private String messageIn;
    private String messageOut;
    private Menu menu;
    private BufferedReader in;
    private boolean exit;


    public PlayerHandler(Socket playerSocket){
        this.playerSocket = playerSocket;

    }


  public void handleClient(Socket clientSocket){

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            menu = new Menu(this);



            while (true) {

                if(messageOut == "Start Game" || messageOut == "Join Game") {
                    messageOut = "";
                    out.write(Messages.PLAYERS_CONNECTED);
                    out.flush();

                } else {
                    out.print("\u001B[2J");

                    out.write(menu.getMenu());
                    out.flush();
                    messageIn = in.readLine();
                }

                menu.onMenuSelection(messageIn);

                if (exit) {
                    in.close();
                    clientSocket.close();
                    return;
                }


                if(messageOut == "/quit"){
                        menu.showMenu();
                }
            }
        } catch (IOException e){


            e.printStackTrace();
        }

    }

    public void close() {

        this.exit = true;

    }



    @Override
    public void run() {
        handleClient(playerSocket);
    }


    public PrintWriter getOut() {
        return out;
    }


    public BufferedReader getIn() {
        return in;
    }

    public Socket getPlayerSocket() {
        return playerSocket;
    }
}
