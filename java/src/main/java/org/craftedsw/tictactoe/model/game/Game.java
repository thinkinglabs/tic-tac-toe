package org.craftedsw.tictactoe.model.game;

import org.craftedsw.tictactoe.model.board.BoardLines;
import org.craftedsw.tictactoe.model.board.Marks;
import org.craftedsw.tictactoe.view.BoardDisplay;

import static java.util.Arrays.copyOf;
import static org.craftedsw.tictactoe.model.board.BoardStructure.EMPTY_BOARD;

public class Game {

    private final BoardDisplay boardDisplay;
    private Marks marks = initialiseMarks();

    private BoardLines boardLines = newBoardLines();

    private Player crossesPlayer;
    private Player noughtsPlayer;
    private Player currentPlayer;

    public Game(BoardDisplay boardDisplay, Player noughtsPlayer, Player crossesPlayer) {
        this.boardDisplay = boardDisplay;
        this.noughtsPlayer = noughtsPlayer;
        this.crossesPlayer = crossesPlayer;
        this.currentPlayer = noughtsPlayer;
    }

    public void startNewGame() {
        boardDisplay.displayGameInstructions(marks);
        while (!isOver()) {
            currentPlayer.placeMark(marks);
            boardDisplay.displayBoard(marks);
            switchCurrentPlayer();
        }
    }

    public void displayGameResult() {
        PlayerMark winner = boardLines.winner(marks);
        boardDisplay.displayGameResult(winner);
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer.equals(noughtsPlayer)
                                ? crossesPlayer
                                : noughtsPlayer;
    }

    private boolean isOver() {
        return hasWinner() || marks.isFull();
    }

    private boolean hasWinner() {
        return boardLines.hasWinnerLine(marks);
    }

    protected Marks initialiseMarks() {
        return new Marks(copyOf(EMPTY_BOARD, EMPTY_BOARD.length));
    }

    protected BoardLines newBoardLines() {
        return new BoardLines();
    }

}