package org.craftedsw.tictactoe.strategy;

import org.craftedsw.tictactoe.Board;
import org.craftedsw.tictactoe.Marks;
import org.junit.Test;

import static org.craftedsw.tictactoe.Board.CELL_1;
import static org.craftedsw.tictactoe.Board.CELL_2;
import static org.craftedsw.tictactoe.Board.CELL_3;
import static org.craftedsw.tictactoe.Player.PLAYER_ONE;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FirstEmptyCellStrategyShould {

    @Test public void
    should_return_first_cell_when_there_are_no_marks() {
        Marks marks = marks().build();

        FirstEmptyCellStrategy strategy = new FirstEmptyCellStrategy();

        assertThat(strategy.nextCell(PLAYER_ONE, marks), is(CELL_1));
    }

    @Test public void
    should_return_first_empty_cell_when_marks_already_exist() {
        Marks marks = marks()
                        .fromPlayerOneAt(CELL_1)
                        .fromPlayerTwoAt(CELL_3).build();

        FirstEmptyCellStrategy strategy = new FirstEmptyCellStrategy();

        assertThat(strategy.nextCell(PLAYER_ONE, marks), is(CELL_2));
    }

}
