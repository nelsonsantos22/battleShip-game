package org.academiadecodigo.battleship.server;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class PlayerHandler implements Runnable{

    private Socket playerSocket;
    //private BufferedReader in;
    private PrintWriter out;
    LinkedList<PlayerHandler> list;

    public PlayerHandler(Socket clientSocket/*, LinkedList list*/){
        this.playerSocket = clientSocket;
       /* this.list = list;*/
        handleClient(clientSocket);


    }

    public void handleClient(Socket clientSocket){

        try {


            out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String messageIn;

            while (true) {

                out.write("hey koi");
                out.flush();

                messageIn = in.readLine();

                if (messageIn == null || messageIn.equals("/quit")) {
                    //System.out.println("*** " + Thread.currentThread().getName() + " disconnected from the chat");
                    in.close();
                    clientSocket.close();
                    break;
                }

                System.out.println(Thread.currentThread().getName() + ": " + messageIn);

            }
        } catch (IOException e){

            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        handleClient(playerSocket);
    }



}
