package instruction;


import data.Grid;
import data.Position;

import java.util.List;

public class Robot
{
    private Orientation currentOrientation;
    private Position currentPosition;
    private boolean isLost = false;

    public Robot(Position initialPosition, Orientation initialOrientation)
    {
        currentPosition = initialPosition;
        currentOrientation = initialOrientation;
    }

    public void executeInstructions(Grid grid, List<Instruction> instructions)
    {
        for (Instruction instruction : instructions)
        {
            if (isLost)
            {
                break;
            } else
            {
                instruction.execute(this);
                updateRobotLostStatus(grid);
            }
            //check if previous robot has left "scent", i.e. grid has a record of robot being lsot
            //grid.isInstructionGoingToLoseRobot(this)
        }
    }

    private void updateRobotLostStatus(Grid grid)
    {
        if (isRobotLost(grid))
        {
            isLost = true;
        }
    }

    private boolean isRobotLost(Grid grid)
    {
        return !grid.isPositionOnGrid(currentPosition);
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

    public boolean isLost()
    {
        return isLost;
    }
}
