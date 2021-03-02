package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bb = new BishopBlack(Cell.D4);
        Cell c = bb.position();
        assertEquals(Cell.D4, c);
    }

    @Test
    public void way() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] c = bb.way(Cell.C1,Cell.G5);
        Cell[] b = {Cell.D2,Cell.E3,Cell.F4, Cell.G5};
        assertArrayEquals(b, c);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenNotDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] c = bb.way(Cell.C1,Cell.G3);
    }

    @Test
    public void isDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        assertFalse(bb.isDiagonal(Cell.C1,Cell.G3));
        assertTrue(bb.isDiagonal(Cell.C1,Cell.G5));
    }

    @Test
    public void copy() {
        BishopBlack bb = new BishopBlack(Cell.D4);
        bb = (BishopBlack) bb.copy(Cell.A4);
        Cell c = bb.position();
        assertEquals(Cell.A4, c);
    }
}