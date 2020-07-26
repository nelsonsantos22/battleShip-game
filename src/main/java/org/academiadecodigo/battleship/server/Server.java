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
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private ExecutorService fixedPool = Executors.newFixedThreadPool(2);
    private LinkedList<PlayerHandler> list = new LinkedList<>();
    private int port;
    private Game game = new Game();


    public Server() {
        init();

    }

    private void init() {

        Prompt prompt = new Prompt(System.in,System.out);

        IntegerInputScanner portScanner = new IntegerInputScanner();

        portScanner.setMessage("Port: ");
        port = prompt.getUserInput(portScanner);

        startServer();

    }

    public void startServer() {

        try {

            serverSocket = new ServerSocket(port);

            System.out.println("Server started: " + serverSocket);

            System.out.println("Waiting for a player connection");

            while (true) {

                clientSocket = serverSocket.accept();

                PlayerHandler playerHandler = new PlayerHandler(clientSocket);
                fixedPool.execute(playerHandler);
                list.add(playerHandler);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
