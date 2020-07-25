package org.academiadecodigo.battleship.menu;

import org.academiadecodigo.battleship.util.Messages;

/**
 * The possible operation types
 */
public enum MenuOptions {

    START_GAME(1, Messages.MENU_START_GAME),

    JOIN_GAME(2, Messages.MENU_JOIN_GAME),

    CREDITS(3, Messages.MENU_CREDITS),

    HOW_TO_PLAY(4, Messages.MENU_HOW_TO_PLAY),

    QUIT(5, Messages.MENU_QUIT);

    private int option;
    private String message;

    MenuOptions(int option, String message) {
        this.option = option;
        this.message = message;
    }

    /**
     * Gets the user option number
     *
     * @return the option number
     */
    public int getOption() {
        return option;
    }

    /**
     * Gets the message for the user option
     *
     * @return the user option message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the messages for the options the user can perform
     *
     * @return an array containing all the messages
     */
    public static String[] getMessages() {

        String[] messages = new String[values().length];

        for (MenuOptions option : values()) {
            messages[option.getOption() - 1] = option.getMessage();
        }

        return messages;
    }
}

