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

                    out.write(menu.getMenu());
                    out.flush();
                    messageIn = in.readLine();
                }


                if (messageIn == null || messageIn.equals("/quit")) {
                    in.close();
                    clientSocket.close();
                    break;
                }

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


    public PrintWriter getOut() {
        return out;
    }


    public BufferedReader getIn() {
        return in;
    }
}
