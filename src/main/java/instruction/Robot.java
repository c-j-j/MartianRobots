package instruction;


import data.Grid;
import data.Position;

import java.util.List;

public class Robot {
    private int xCoordinate;
    private int yCoordinate;
    private Orientation orientation;
    private Position currentPosition;

    public Robot(int initialXCoordinate, int initialYCoordinate, Orientation orientation) {
        xCoordinate = initialXCoordinate;
        yCoordinate = initialYCoordinate;
        this.orientation = orientation;
    }

    public void executeInstructions(Grid grid, List<Instruction> instructions) {
        for (Instruction instruction : instructions) {

            //check if robot is lost, i.e. grid.isRobotLost(this)
            //check if previous robot has left "scent", i.e. grid has a record of robot being lsot
            //grid.isInstructionGoingToLoseRobot(this)
            //execute command

            instruction.execute(this);
        }
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void updatePosition(Position newPosition) {

    }
}
