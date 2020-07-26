package org.academiadecodigo.battleship.util;

/**
 * Messages to be used in the game
 */

public class Messages {


    //BattleShip Logo
    public final static String LOGO = "\u001B[36m__________         __    __  .__           _________.__    .__        \n" + "\\______   \\_____ _/  |__/  |_|  |   ____  /   _____/|  |__ |__|_____  \n" + " |    |  _/\\__  \\   __\\   __\\  | _/ __ \\ \\_____  \\ |  |  \\|  \\____ \\ \n" + " |    |   \\ / __ \\|  |  |  | |  |_\\  ___/ /        \\|   Y  \\  |  |_> >\n" + " |______  /(____  /__|  |__| |____/\\___  >_______  /|___|  /__|   __/ \n" + "        \\/      \\/                     \\/        \\/      \\/   |__|    \n\u001B[37m";

    //Menu Messages
    public final static String MENU_START_GAME = "Start Game";
    public final static String MENU_CREDITS = "Credits";
    public final static String MENU_HOW_TO_PLAY = "How To Play";
    public final static String MENU_QUIT = "Quit";

    //Game Messages
    public final static String WIN = "Well done! You've destroyed 5 enemy boats in ";
    public final static String HIT_BOAT = "Good shoot! You hit an enemy boat located in ";

    //Connection Messages
    public final static String PLAYERS_CONNECTED = "ALL players are connected";
    public final static String CONNECTION_ERROR = "Connection Failed";


    public static final String CREDITS = "\n\n                           Game created by : \n                            Joana Marques \n                            Nelson Santos \n                            Rafael Moreira \n                            Ricardo Pinho \n\n\n\n";
    public static final String HTP = "\n\nYou have to destroy the 5 hidden boats.\n\nYou have to pick a number between 1 and 10 to choose the row " +
            "and again to choose the column.\n\nThe game ends when you destroy the 5 boats.\n\nLegend:\n\n~: Water\nO: Missed shot\nX: Boat Destroyed\n\nThanks for playing, Hope you enjoyed playing our game as much we enjoyed making it!\n\n";
}
