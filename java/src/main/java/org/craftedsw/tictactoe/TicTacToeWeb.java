package org.craftedsw.tictactoe;

import org.craftedsw.tictactoe.controller.MainController;

public class TicTacToeWeb {

    public static void main(String[] args) {

        new MainController(new ViewRenderer());
    }

}