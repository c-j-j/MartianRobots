package instruction;


import data.Grid;
import data.Position;

import java.util.List;

public class Robot
{
    private Orientation currentOrientation;
    private Position currentPosition;

    public Robot(Position initialPosition, Orientation initialOrientation)
    {
        currentPosition = initialPosition;
        currentOrientation = initialOrientation;
    }

    public void executeInstructions(Grid grid, List<Instruction> instructions)
    {
        for (Instruction instruction : instructions)
        {

            //check if robot is lost, i.e. grid.isRobotLost(this)
            //check if previous robot has left "scent", i.e. grid has a record of robot being lsot
            //grid.isInstructionGoingToLoseRobot(this)
            //execute command

            instruction.execute(this);
        }
    }

    public Position getCurrentPosition()
    {
        return currentPosition;
    }

    public Orientation getCurrentOrientation()
    {
        return currentOrientation;
    }

    public void updateOrientation(Orientation orientation)
    {
        this.currentOrientation = orientation;
    }

    public void updatePosition(Position newPosition)
    {
        currentPosition = newPosition;
    }
}
