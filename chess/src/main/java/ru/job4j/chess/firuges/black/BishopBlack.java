package ru.job4j.chess.firuges.black;

import javafx.scene.chart.ScatterChart;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new ImpossibleMoveException (
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }

        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) / Math.abs(dest.x - source.x);
        int deltaY = (dest.y - source.y) / Math.abs(dest.y - source.y);
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + index * deltaX + deltaX,source.y + index * deltaY + deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (dest.x - source.x == dest.y - source.y) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
