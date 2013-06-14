package org.craftedsw.tictactoe.model.board;

import org.craftedsw.tictactoe.model.game.Player;
import org.craftedsw.tictactoe.view.BoardDisplay;

import static org.craftedsw.tictactoe.model.game.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.model.game.Player.PLAYER_TWO;

public class Board {

    public static final int CELL_1 = 0;
    public static final int CELL_2 = 1;
    public static final int CELL_3 = 2;
    public static final int CELL_4 = 3;
    public static final int CELL_5 = 4;
    public static final int CELL_6 = 5;
    public static final int CELL_7 = 6;
    public static final int CELL_8 = 7;
    public static final int CELL_9 = 8;

    public static final int NO_CELL = -1;
    public static final String EMPTY_CELL = " ";

    public static final int[] ALL_CELLS = new int[] {
            CELL_1, CELL_2, CELL_3,
            CELL_4, CELL_5, CELL_6,
            CELL_7, CELL_8, CELL_9
    };
    public static final int[] CORNER_CELLS = new int[] {CELL_1, CELL_3, CELL_7, CELL_9};

    public static final int[][] OPPOSITE_CORNER_CELLS = new int[][] {
            {CELL_1, CELL_9},
            {CELL_9, CELL_1},
            {CELL_3, CELL_7},
            {CELL_7, CELL_3},
    };

    private Marks marks = new Marks(new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "});
    private BoardLines boardLines = new BoardLines();

    private Player currentPlayer = PLAYER_ONE;


    public static final String ASK_FOR_NEXT_MARK = "Cell number for your next mark  >>> ";

    public String representation() {
        return BoardDisplay.representation(marks);
    }

    public void place(int cellToBeMarked) {
        marks.placeMarkAt(cellToBeMarked, currentPlayer.mark());
        if (!hasWinner()) {
            switchPlayers();
        }
    }

    public boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    public Player winner() {
        return currentPlayer;
    }

    public Marks marks() {
        return marks;
    }

    private void switchPlayers() {
        currentPlayer = (currentPlayer == PLAYER_ONE)
                                ? PLAYER_TWO
                                : PLAYER_ONE;
    }

    public boolean isFull() {
        return marks().isFull();
    }
}