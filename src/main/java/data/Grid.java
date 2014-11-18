package data;

import data.Position;
import instruction.Instruction;

public class Grid {
    private final int upperXCoordinate;
    private final int upperYCoordinate;

    public Grid(int upperXCoordinate, int upperYCoordinate) {

        this.upperXCoordinate = upperXCoordinate;
        this.upperYCoordinate = upperYCoordinate;
    }

    public Position calculateNextPosition(int currentXCoordinate, int currentYCoordinate, Instruction instruction) {
        return null;
    }
}
