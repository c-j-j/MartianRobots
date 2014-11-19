package robot;


import data.Grid;
import data.Position;
import instruction.Instruction;
import instruction.Orientation;

import java.util.List;

public class Robot
{
    private Orientation currentOrientation;
    private Position currentPosition;
    private boolean isLost = false;
    private Position previousPosition;

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
                processInstruction(grid, instruction);
            }
        }
    }

    private void processInstruction(Grid grid, Instruction instruction)
    {
        if (!grid.willNextMoveLoseRobot(currentPosition, currentOrientation, instruction))
        {
            previousPosition = currentPosition;
            instruction.execute(this);
            updateRobotLostStatus(grid);
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

    public Position getPreviousPosition()
    {
        return previousPosition;
    }
}
