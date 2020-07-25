package org.academiadecodigo.battleship.server;

import org.academiadecodigo.battleship.Game;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader inputBufferedReader;
    private int port;

    Game game;

    public Server() {

        init();

        startServer();

    }

    private void init() {
        Prompt prompt = new Prompt(System.in,System.out);

        IntegerInputScanner portScanner = new IntegerInputScanner();

        portScanner.setMessage("Port: ");
        port = prompt.getUserInput(portScanner);
    }

    public void startServer() {

        try {

            serverSocket = new ServerSocket(port);

            System.out.println("Server started: " + serverSocket);

            // block waiting for a client to connect
            System.out.println("Waiting for a player connection");

            while (true) {

                clientSocket = serverSocket.accept();

                PlayerHandler playerHandler = new PlayerHandler(clientSocket);
                //playerHandler.handleClient();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
