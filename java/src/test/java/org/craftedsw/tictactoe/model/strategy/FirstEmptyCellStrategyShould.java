package org.craftedsw.tictactoe.model.strategy;

import org.craftedsw.tictactoe.model.board.Marks;
import org.junit.Test;

import static org.craftedsw.tictactoe.builder.MarksBuilder.emptyMarks;
import static org.craftedsw.tictactoe.builder.MarksBuilder.marks;
import static org.craftedsw.tictactoe.model.board.BoardStructure.*;
import static org.craftedsw.tictactoe.model.game.PlayerMark.CROSS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FirstEmptyCellStrategyShould {

    @Test public void
    should_return_first_cell_when_there_are_no_marks() {
        Marks marks = emptyMarks();

        FirstEmptyCellStrategy strategy = new FirstEmptyCellStrategy();

        assertThat(strategy.nextCell(CROSS, marks), is(CELL_1));
    }

    @Test public void
    should_return_first_empty_cell_when_marks_already_exist() {
        Marks marks = marks()
                            .fromPlayerOneAt(CELL_1)
                            .fromPlayerTwoAt(CELL_3).build();

        FirstEmptyCellStrategy strategy = new FirstEmptyCellStrategy();

        assertThat(strategy.nextCell(CROSS, marks), is(CELL_2));
    }

}
