package org.craftedsw.tictactoe;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.craftedsw.tictactoe.Board.*;

public class Marks {
    private final String[] marks;

    public Marks(String[] marksArray) {
        this.marks = marksArray;
    }

    public boolean isEmpty() {
        return stringRepresentation().trim().isEmpty();
    }

    public boolean containsSingleMark() {
        return stringRepresentation().trim().length() == 1;
    }

    public boolean hasAnyCornerMarked() {
        return atLeastOneIsMarked(CELL_1, CELL_3, CELL_7, CELL_9);
    }

    public int oppositeCornerOf(int cell) {
        for (int[] oppositeCells : OPPOSITE_CORNER_CELLS) {
            if (cell == oppositeCells[0]) {
                return oppositeCells[1];
            }
        }
        return NO_CELL;
    }

    public int emptyOppositeCell(int cell) {
        int oppositeCell = oppositeCornerOf(cell);
        return (isEmpty(oppositeCell))
                    ? oppositeCell
                    : NO_CELL;
    }

    public String[] asArray() {
        return this.marks;
    }

    private boolean isEmpty(int cell) {
        return EMPTY_CELL.equals(marks[cell]);
    }

    private String stringRepresentation() {
        StringBuilder builder = new StringBuilder();
        for (String mark : marks) {
            builder.append(mark);
        }
        return builder.toString();
    }

    private boolean atLeastOneIsMarked(int... cells) {
        for (int cell : cells) {
            if (!EMPTY_CELL.equals(marks[cell])) {
                return true;
            }
        }
        return false;
    }

    public int firstEmptyCell() {
        return asList(marks).indexOf(EMPTY_CELL);
    }
}